package com.asdevelopers.academy.basic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.asdevelopers.academy.core.progress.CourseOutlineEngine
import com.asdevelopers.academy.core.repository.CourseOutlineRepository
import com.asdevelopers.academy.core.ui.screens.AcademyCourseHomeScreen
import com.asdevelopers.academy.core.content.CourseBundle

/**
 * Adapter اختصاصی Basic فقط Bundle و callbackها را به Home عمومی Core می‌دهد.
 * هیچ منطق Level/Chapter/Lesson/Progress در Repository دوره تکرار نمی‌شود.
 */
@Composable
fun BasicCourseHome(
    bundle: CourseBundle,
    outlineRepository: CourseOutlineRepository,
    onLessonClick: (String) -> Unit,
    onPlacementClick: () -> Unit,
    onWeakTopicReviewClick: () -> Unit,
    onFlashcardReviewClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val outlineFlow = remember(bundle.manifest.version) {
        outlineRepository.observe(bundle)
    }
    // مدل اولیه از همان Engine مشترک ساخته می‌شود تا قبل از اولین emission Room نیز ساختار صحیح نمایش داده شود.
    val initialOutline = remember(bundle.manifest.version) {
        CourseOutlineEngine.build(bundle, emptyList())
    }
    val outline by outlineFlow.collectAsState(initial = initialOutline)

    AcademyCourseHomeScreen(
        outline = outline,
        onLessonClick = onLessonClick,
        onContinueClick = onLessonClick,
        onPlacementClick = onPlacementClick,
        onWeakTopicReviewClick = onWeakTopicReviewClick,
        onFlashcardReviewClick = onFlashcardReviewClick,
        modifier = modifier
    )
}
