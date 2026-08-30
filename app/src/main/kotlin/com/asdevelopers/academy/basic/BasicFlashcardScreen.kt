package com.asdevelopers.academy.basic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.asdevelopers.academy.core.content.CourseBundle
import com.asdevelopers.academy.core.database.AcademyDatabase
import com.asdevelopers.academy.core.repository.FlashcardReviewRepository
import com.asdevelopers.academy.core.ui.flashcard.FlashcardDeck
import com.asdevelopers.academy.course.model.Flashcard
import kotlinx.coroutines.launch

/**
 * Wiring اختصاصی Basic برای صفحه مرور Flashcard.
 *
 * خود مدل کارت، Spaced Review، Room Repository و Deck UI در Core هستند؛ این فایل فقط کارت‌های Bundle Basic را
 * به Stateهای موعدرسیده همان Course متصل می‌کند و هیچ الگوریتم یا دیتابیس اختصاصی دوره نمی‌سازد.
 */
@Composable
fun BasicFlashcardScreen(
    bundle: CourseBundle?,
    database: AcademyDatabase,
    modifier: Modifier = Modifier
) {
    // Repository مشترک Core با DAO همان دیتابیس پایدار Host ساخته می‌شود.
    val repository = remember(database) { FlashcardReviewRepository(database.flashcardReviewDao()) }
    // Scope فقط Rating کاربر را بدون مسدودکردن UI در Room ثبت می‌کند.
    val scope = rememberCoroutineScope()
    // null یعنی Snapshot هنوز از Room خوانده نشده؛ empty یعنی امروز کارتی موعد ندارد.
    var sessionCards by remember(bundle?.manifest?.courseId) { mutableStateOf<List<Flashcard>?>(null) }

    // هر بار Course عوض شود یک Snapshot تازه از کارت‌های Due ساخته می‌شود؛ در طول Session ثابت می‌ماند.
    LaunchedEffect(bundle?.manifest?.courseId, bundle?.flashcards) {
        val course = bundle
        if (course == null) {
            sessionCards = null
            return@LaunchedEffect
        }

        val dueStates = repository.getDue(
            courseId = course.manifest.courseId,
            nowEpochMillis = System.currentTimeMillis(),
            limit = 200
        )
        // ترتیب Due از Repository حفظ می‌شود و کارت حذف‌شده از Content Update بی‌خطر نادیده گرفته می‌شود.
        val cardsById = course.flashcards.associateBy(Flashcard::id)
        sessionCards = dueStates.mapNotNull { state -> cardsById[state.flashcardId] }
    }

    when {
        // Bundle یا Snapshot هنوز آماده نیست.
        bundle == null || sessionCards == null -> Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }

        // Course قابلیت را فعال کرده ولی محتوای کارت ندارد؛ این حالت در CI Warning می‌گیرد.
        bundle.flashcards.isEmpty() -> ReviewMessage(
            title = "Flashcard آماده نیست",
            message = "برای این دوره هنوز کارت مرور تعریف نشده است.",
            modifier = modifier
        )

        // Snapshot خالی یعنی همه کارت‌های موعدرسیده امروز مرور شده‌اند.
        sessionCards.orEmpty().isEmpty() -> ReviewMessage(
            title = "مرور امروز کامل است",
            message = "فعلاً Flashcard موعدرسیده‌ای ندارید. موعد بعدی بر اساس پاسخ‌های قبلی محاسبه می‌شود.",
            modifier = modifier
        )

        else -> FlashcardDeck(
            cards = sessionCards.orEmpty(),
            modifier = modifier.padding(16.dp),
            onReview = { card, rating ->
                // Rating به Repository مشترک می‌رود و State جدید همان لحظه در Room پایدار می‌شود.
                scope.launch {
                    repository.recordReview(
                        courseId = card.courseId,
                        flashcardId = card.id,
                        rating = rating,
                        reviewedAtEpochMillis = System.currentTimeMillis()
                    )
                }
            }
        )
    }
}

/** Empty/complete state سبک؛ الگوریتم مرور و Card UI همچنان در Core باقی می‌ماند. */
@Composable
private fun ReviewMessage(
    title: String,
    message: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(title, style = MaterialTheme.typography.headlineSmall)
        Text(
            text = message,
            modifier = Modifier.padding(top = 10.dp),
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
