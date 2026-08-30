package com.asdevelopers.academy.basic

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.asdevelopers.academy.core.repository.LessonProgressRepository
import com.asdevelopers.academy.core.ui.screens.AcademyLessonScreen
import com.asdevelopers.academy.course.model.Lesson
import kotlinx.coroutines.launch

/**
 * Adapter بسیار نازک Basic برای Lesson Screen عمومی.
 * ثبت Open/Complete در Core انجام می‌شود و این فایل فقط Stable IDهای Course را وصل می‌کند.
 */
@Composable
fun BasicLessonRoute(
    lesson: Lesson,
    progressRepository: LessonProgressRepository,
    onQuizClick: (String) -> Unit,
    onExerciseClick: (String) -> Unit,
    onProjectClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val progressFlow = remember(lesson.id) {
        progressRepository.observe(BASIC_COURSE_ID, lesson.id)
    }
    val progress by progressFlow.collectAsState(initial = null)

    // ورود واقعی کاربر به Route درس، وضعیت Continue Learning و lastOpenedAt را به‌روز می‌کند.
    LaunchedEffect(lesson.id) {
        progressRepository.markOpened(
            courseId = BASIC_COURSE_ID,
            lessonId = lesson.id,
            openedAtEpochMillis = System.currentTimeMillis()
        )
    }

    AcademyLessonScreen(
        lesson = lesson,
        progress = progress,
        onQuizClick = onQuizClick,
        onExerciseClick = onExerciseClick,
        onProjectClick = onProjectClick,
        onCompleteClick = {
            scope.launch {
                progressRepository.markCompleted(
                    courseId = BASIC_COURSE_ID,
                    lessonId = lesson.id,
                    completedAtEpochMillis = System.currentTimeMillis(),
                    lastBlockIndex = lesson.blocks.lastIndex.coerceAtLeast(0)
                )
            }
        },
        modifier = modifier
    )
}

private const val BASIC_COURSE_ID = "basic"
