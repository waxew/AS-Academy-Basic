package com.asdevelopers.academy.basic

import androidx.compose.runtime.Composable
import com.asdevelopers.academy.mainui.AcademyAppInfo
import com.asdevelopers.academy.mainui.AcademyCompiledCourseHost

/**
 * Basic is a thin AS Academy Course App.
 *
 * Core owns runtime/persistence, MainUi owns presentation/navigation/workflow wiring, and
 * MainCourse owns the canonical curriculum. This host owns only app identity and course binding.
 */
@Composable
fun BasicAcademyApp() {
    AcademyCompiledCourseHost(
        courseId = BASIC_COURSE_ID,
        assetPath = BASIC_COURSE_ASSET,
        appTitle = "Basic",
        appInfo = AcademyAppInfo(
            versionName = BuildConfig.VERSION_NAME,
            description = "دوره پایه و پیش‌نیاز مشترک برنامه‌نویسی در AS Academy؛ از سواد رایانه و حل مسئله تا مهندسی نرم‌افزار و آمادگی بازار کار.",
            shareText = "Basic — مبانی مشترک برنامه‌نویسی | AS Academy",
            updateUri = "https://github.com/waxew/AS-Academy-Basic/releases"
        ),
        databaseName = "basic_academy.db",
        placementQuizId = BASIC_PLACEMENT_QUIZ_ID
    )
}

private const val BASIC_COURSE_ID = "basic"
private const val BASIC_COURSE_ASSET = "basic-course.json"
private const val BASIC_PLACEMENT_QUIZ_ID = "basic-qz-placement-001"
