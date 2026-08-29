package com.asdevelopers.academy.basic

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MenuBook
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.asdevelopers.academy.core.content.AssetCoursePackageSource
import com.asdevelopers.academy.core.content.CourseBundle
import com.asdevelopers.academy.core.content.CourseLoadResult
import com.asdevelopers.academy.core.content.CoursePackageLoader
import com.asdevelopers.academy.core.database.AcademyDatabase
import com.asdevelopers.academy.core.exercise.ExerciseDraft
import com.asdevelopers.academy.core.navigation.AcademyNavHost
import com.asdevelopers.academy.core.navigation.AcademyRoutes
import com.asdevelopers.academy.core.navigation.openAbout
import com.asdevelopers.academy.core.navigation.openExercise
import com.asdevelopers.academy.core.navigation.openLesson
import com.asdevelopers.academy.core.navigation.openProject
import com.asdevelopers.academy.core.navigation.openQuiz
import com.asdevelopers.academy.core.navigation.openSettings
import com.asdevelopers.academy.core.notification.StudyReminderScheduler
import com.asdevelopers.academy.core.progress.LearningCompletion
import com.asdevelopers.academy.core.progress.LearningTargetType
import com.asdevelopers.academy.core.repository.ExerciseDraftRepository
import com.asdevelopers.academy.core.repository.LearningCompletionRepository
import com.asdevelopers.academy.core.repository.ProjectProgressRepository
import com.asdevelopers.academy.core.repository.QuizHistoryRepository
import com.asdevelopers.academy.core.settings.AcademyPreferencesRepository
import com.asdevelopers.academy.core.settings.AcademyProfile
import com.asdevelopers.academy.core.settings.AcademySettings
import com.asdevelopers.academy.core.settings.AcademyThemeMode
import com.asdevelopers.academy.core.ui.components.AcademyAppShell
import com.asdevelopers.academy.core.ui.components.AcademyDrawerItem
import com.asdevelopers.academy.core.ui.content.LessonRenderer
import com.asdevelopers.academy.core.ui.screens.AcademyAboutScreen
import com.asdevelopers.academy.core.ui.screens.AcademyExerciseScreen
import com.asdevelopers.academy.core.ui.screens.AcademyProjectScreen
import com.asdevelopers.academy.core.ui.screens.AcademyQuizScreen
import com.asdevelopers.academy.core.ui.screens.AcademySettingsScreen
import com.asdevelopers.academy.core.ui.theme.AcademyTheme
import com.asdevelopers.academy.core.ui.theme.DefaultAcademyBranding
import kotlinx.coroutines.launch

/**
 * Host اختصاصی Basic فقط Course Bundle، Branding و اتصال Repositoryها را فراهم می‌کند.
 * Navigation، Drawer، Quiz/Exercise/Project UI و تمام Engineها از AS-Academy-Core مصرف می‌شوند.
 */
@Composable
fun BasicAcademyApp() {
    // Context برای Loader، Room، DataStore، Intentها و Scheduler مورد نیاز است.
    val context = LocalContext.current
    // NavController توسط NavHost مشترک Core مدیریت می‌شود.
    val navController = rememberNavController()
    // CoroutineScope برای عملیات غیرهمزمان Room و DataStore استفاده می‌شود.
    val scope = rememberCoroutineScope()

    // DataStore مشترک پروفایل و تنظیمات را بدون وابستگی Course نگهداری می‌کند.
    val preferences = remember { AcademyPreferencesRepository(context) }
    // Scheduler مشترک یادآور مطالعه را مدیریت می‌کند.
    val reminderScheduler = remember { StudyReminderScheduler(context) }
    // Room مرکزی با نام اختصاصی Host ساخته می‌شود تا داده‌های Basic پایدار بمانند.
    val database = remember { AcademyDatabase.create(context, "basic_academy.db") }
    // Repository تاریخچه آزمون، QuizScore را بدون SQL مستقیم از Host ذخیره می‌کند.
    val quizHistoryRepository = remember(database) { QuizHistoryRepository(database.quizResultDao()) }
    // Draft تمرین از Repository مشترک و جدول چنددوره‌ای استفاده می‌کند.
    val exerciseDraftRepository = remember(database) { ExerciseDraftRepository(database.exerciseDraftDao()) }
    // Completion تمرین و پروژه برای Dashboard و Achievement قابل استفاده است.
    val completionRepository = remember(database) {
        LearningCompletionRepository(database.learningCompletionDao())
    }
    // وضعیت Milestone و Draft پروژه با ProjectProgressRepository نگهداری می‌شود.
    val projectProgressRepository = remember(database) {
        ProjectProgressRepository(database.projectProgressDao())
    }

    // هنگام خارج شدن Host، Connection دیتابیس بسته می‌شود و هیچ Singleton مخفی باقی نمی‌ماند.
    DisposableEffect(database) {
        onDispose { database.close() }
    }

    // Profile از DataStore مشترک به‌صورت reactive خوانده می‌شود.
    val profile by preferences.profile.collectAsState(initial = AcademyProfile())
    // Settings نیز reactive است و تغییر Theme/Font بلافاصله UI را Recompose می‌کند.
    val settings by preferences.settings.collectAsState(initial = AcademySettings())
    // Loader چهار حالت loading/success/invalid/failure را در این State قرار می‌دهد.
    var courseResult by remember { mutableStateOf<CourseLoadResult?>(null) }

    // Bundle خروجی Compiler رسمی Core از assets خوانده و دوباره Validate می‌شود.
    LaunchedEffect(Unit) {
        courseResult = CoursePackageLoader().load(
            AssetCoursePackageSource(context, "basic-course.json")
        )
    }

    // انتخاب تصویر پروفایل در Host انجام می‌شود اما داده آن در DataStore مشترک ذخیره می‌شود.
    val imagePicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            // مجوز URI برای اجرای بعدی برنامه حفظ می‌شود؛ شکست این مرحله اپ را متوقف نمی‌کند.
            runCatching {
                context.contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
            }
            // فقط URI ذخیره می‌شود تا فایل شخصی کاربر بی‌دلیل کپی نشود.
            scope.launch {
                preferences.updateProfile(profile.displayName, uri.toString())
            }
        }
    }

    // Android 13+ اعلان را فقط بعد از مجوز Runtime نمایش می‌دهد.
    val notificationPermission = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        // اگر مجوز رد شود Toggle نیز به وضعیت واقعی سیستم برگردانده می‌شود.
        if (!granted) {
            scope.launch { preferences.setNotificationsEnabled(false) }
        }
    }

    // فقط Result موفق Bundle معتبر در اختیار UI و Activity Screenها قرار می‌گیرد.
    val bundle = (courseResult as? CourseLoadResult.Success)?.bundle

    // Drawer فقط گزینه‌های اختصاصی Course را تعریف می‌کند؛ Settings/Share/About از Core می‌آیند.
    val drawerItems = listOf(
        AcademyDrawerItem(
            id = "basic-home",
            label = "خانه",
            icon = Icons.Outlined.Home,
            selected = true
        ) {
            // Home به شکل SingleTop باز می‌شود تا Back stack با نسخه‌های تکراری Home پر نشود.
            navController.navigate(AcademyRoutes.HOME) {
                launchSingleTop = true
                popUpTo(AcademyRoutes.HOME)
            }
        },
        AcademyDrawerItem(
            id = "basic-first-lesson",
            label = "شروع یادگیری",
            icon = Icons.Outlined.MenuBook
        ) {
            // اولین Lesson موجود در Bundle نقطه شروع سریع کاربر است.
            bundle?.lessons?.firstOrNull()?.let { lesson ->
                navController.openLesson(lesson.id)
            }
        }
    )

    // Theme ذخیره‌شده با حالت Dark دستگاه ترکیب می‌شود.
    val useDarkTheme = when (settings.themeMode) {
        AcademyThemeMode.SYSTEM -> isSystemInDarkTheme()
        AcademyThemeMode.LIGHT -> false
        AcademyThemeMode.DARK -> true
    }
    // Density دستگاه مبنای Font scale قابل تنظیم کاربر است.
    val deviceDensity = LocalDensity.current

    // Theme مشترک Core رنگ‌های Course Package را دریافت می‌کند و هیچ رنگی در Host Hard-code نمی‌شود.
    AcademyTheme(
        branding = bundle?.branding ?: DefaultAcademyBranding,
        darkTheme = useDarkTheme
    ) {
        // Font Scale بدون تغییر Density فیزیکی روی تمام Screenهای Core اعمال می‌شود.
        CompositionLocalProvider(
            LocalDensity provides Density(deviceDensity.density, settings.fontScale)
        ) {
            // AppShell مشترک TopBar، Back behavior و Drawer راست را فراهم می‌کند.
            AcademyAppShell(
                title = bundle?.manifest?.titleFa ?: "Basic",
                profile = profile,
                courseItems = drawerItems,
                onProfileImageClick = { imagePicker.launch(arrayOf("image/*")) },
                onSettingsClick = { navController.openSettings() },
                onShareClick = {
                    // اشتراک‌گذاری از Intent استاندارد Android استفاده می‌کند.
                    val shareIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(
                            Intent.EXTRA_TEXT,
                            "Basic — مبانی مشترک برنامه‌نویسی | AS Academy"
                        )
                    }
                    context.startActivity(
                        Intent.createChooser(shareIntent, "اشتراک‌گذاری Basic")
                    )
                },
                onAboutClick = { navController.openAbout() },
                contentIsRtl = bundle?.manifest?.rtl ?: true
            ) { paddingValues ->
                // NavHost مشترک تمام مقصدهای استاندارد را ثبت و Back stack را یکسان نگه می‌دارد.
                AcademyNavHost(
                    navController = navController,
                    home = {
                        BasicHomeScreen(
                            result = courseResult,
                            bundle = bundle,
                            onOpenLesson = { lessonId -> navController.openLesson(lessonId) },
                            modifier = Modifier.padding(paddingValues)
                        )
                    },
                    settings = {
                        // Settings Screen از Core است و Host فقط persistence callback را وصل می‌کند.
                        AcademySettingsScreen(
                            settings = settings,
                            onThemeChanged = { mode ->
                                scope.launch { preferences.setThemeMode(mode) }
                            },
                            onNotificationsChanged = { enabled ->
                                // وضعیت انتخاب کاربر ابتدا در DataStore ثبت می‌شود.
                                scope.launch { preferences.setNotificationsEnabled(enabled) }
                                if (enabled) {
                                    // Android 13+ در صورت نیاز مجوز Notification درخواست می‌کند.
                                    if (
                                        Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU &&
                                        !reminderScheduler.canPostNotifications()
                                    ) {
                                        notificationPermission.launch(Manifest.permission.POST_NOTIFICATIONS)
                                    }
                                    // WorkManager مشترک یادآور روزانه مطالعه را تنظیم می‌کند.
                                    reminderScheduler.scheduleEvery(
                                        1,
                                        "Basic",
                                        "زمان ادامه یادگیری مبانی برنامه‌نویسی است."
                                    )
                                } else {
                                    // خاموش کردن Reminder کار زمان‌بندی‌شده را لغو می‌کند.
                                    reminderScheduler.cancel()
                                }
                            },
                            onFontScaleChanged = { scale ->
                                scope.launch { preferences.setFontScale(scale) }
                            },
                            modifier = Modifier.padding(paddingValues)
                        )
                    },
                    about = {
                        // About عمومی فقط متن و نسخه اختصاصی Course را دریافت می‌کند.
                        AcademyAboutScreen(
                            appTitle = "Basic",
                            description = "دوره پایه و پیش‌نیاز مشترک برنامه‌نویسی در AS Academy؛ از سواد رایانه و حل مسئله تا مهندسی نرم‌افزار و آمادگی بازار کار.",
                            versionName = "0.1.0",
                            modifier = Modifier.padding(paddingValues)
                        )
                    },
                    lesson = { lessonId ->
                        // Lesson با Stable ID از Bundle پیدا و توسط Renderer مشترک نمایش داده می‌شود.
                        val lesson = bundle?.lessons?.firstOrNull { item -> item.id == lessonId }
                        if (lesson == null) {
                            BasicMessage(
                                message = "درس موردنظر پیدا نشد.",
                                modifier = Modifier.padding(paddingValues)
                            )
                        } else {
                            LessonRenderer(
                                lesson = lesson,
                                // دکمه Quiz بلوک درس به Route عمومی آزمون متصل می‌شود.
                                onQuizClick = { quizId -> navController.openQuiz(quizId) },
                                // دکمه Exercise بلوک درس به workflow عمومی تمرین متصل می‌شود.
                                onExerciseClick = { exerciseId -> navController.openExercise(exerciseId) },
                                // دکمه Project بلوک درس نیز Screen مشترک پروژه را باز می‌کند.
                                onProjectClick = { projectId -> navController.openProject(projectId) },
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(paddingValues)
                                    .padding(16.dp)
                            )
                        }
                    },
                    quiz = { quizId ->
                        // Quiz با Stable ID از همان Bundle معتبر پیدا می‌شود.
                        val quiz = bundle?.quizzes?.firstOrNull { item -> item.id == quizId }
                        if (quiz == null) {
                            BasicMessage(
                                message = "آزمون موردنظر پیدا نشد.",
                                modifier = Modifier.padding(paddingValues)
                            )
                        } else {
                            AcademyQuizScreen(
                                quiz = quiz,
                                modifier = Modifier.padding(paddingValues),
                                onCompleted = { score ->
                                    // هر Attempt همراه Weak Tags در Room مشترک ثبت می‌شود.
                                    scope.launch {
                                        quizHistoryRepository.record(
                                            quiz = quiz,
                                            score = score,
                                            completedAt = System.currentTimeMillis()
                                        )
                                    }
                                }
                            )
                        }
                    },
                    exercise = { exerciseId ->
                        // Exercise با Stable ID از Bundle پیدا می‌شود.
                        val exercise = bundle?.exercises?.firstOrNull { item -> item.id == exerciseId }
                        if (exercise == null) {
                            BasicMessage(
                                message = "تمرین موردنظر پیدا نشد.",
                                modifier = Modifier.padding(paddingValues)
                            )
                        } else {
                            // Draft ذخیره‌شده به‌صورت Flow خوانده می‌شود تا پس از بازگشت از صفحه باقی بماند.
                            val draftFlow = remember(exercise.id) {
                                exerciseDraftRepository.observe("basic", exercise.id)
                            }
                            val savedDraft by draftFlow.collectAsState(initial = null)
                            AcademyExerciseScreen(
                                exercise = exercise,
                                initialAnswer = savedDraft?.answer.orEmpty(),
                                modifier = Modifier.padding(paddingValues),
                                onDraftChanged = { answer ->
                                    // هر تغییر Draft با Stable ID Course/Exercise در Room ذخیره می‌شود.
                                    scope.launch {
                                        exerciseDraftRepository.save(
                                            ExerciseDraft(
                                                courseId = "basic",
                                                exerciseId = exercise.id,
                                                answer = answer,
                                                updatedAtEpochMillis = System.currentTimeMillis()
                                            )
                                        )
                                    }
                                },
                                onCompleted = { answer ->
                                    // آخرین پاسخ قبل از Completion نیز ذخیره می‌شود.
                                    scope.launch {
                                        val now = System.currentTimeMillis()
                                        exerciseDraftRepository.save(
                                            ExerciseDraft(
                                                courseId = "basic",
                                                exerciseId = exercise.id,
                                                answer = answer,
                                                updatedAtEpochMillis = now
                                            )
                                        )
                                        // Completion جدا از Draft است و Dashboard می‌تواند آن را مصرف کند.
                                        completionRepository.save(
                                            LearningCompletion(
                                                courseId = "basic",
                                                targetType = LearningTargetType.EXERCISE,
                                                targetId = exercise.id,
                                                completed = true,
                                                completedAtEpochMillis = now
                                            )
                                        )
                                    }
                                }
                            )
                        }
                    },
                    project = { projectId ->
                        // Project با Stable ID از Bundle معتبر انتخاب می‌شود.
                        val project = bundle?.projects?.firstOrNull { item -> item.id == projectId }
                        if (project == null) {
                            BasicMessage(
                                message = "پروژه موردنظر پیدا نشد.",
                                modifier = Modifier.padding(paddingValues)
                            )
                        } else {
                            // Progress پروژه Flow است تا Milestoneها پس از خروج و ورود دوباره بازیابی شوند.
                            val progressFlow = remember(project.id) {
                                projectProgressRepository.observe("basic", project.id)
                            }
                            val savedProgress by progressFlow.collectAsState(initial = null)
                            AcademyProjectScreen(
                                project = project,
                                progress = savedProgress,
                                modifier = Modifier.padding(paddingValues),
                                onProgressChanged = { progress ->
                                    scope.launch {
                                        // وضعیت کامل Milestone و Draft در Repository مشترک ذخیره می‌شود.
                                        projectProgressRepository.save(progress)
                                        // وقتی Screen completedAt تولید کرد، Completion عمومی پروژه نیز ثبت می‌شود.
                                        progress.completedAtEpochMillis?.let { completedAt ->
                                            completionRepository.save(
                                                LearningCompletion(
                                                    courseId = "basic",
                                                    targetType = LearningTargetType.PROJECT,
                                                    targetId = project.id,
                                                    completed = true,
                                                    completedAtEpochMillis = completedAt
                                                )
                                            )
                                        }
                                    }
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}

/** صفحه خانه Basic داده را از Bundle می‌خواند و با اضافه شدن درس‌ها بدون تغییر کد رشد می‌کند. */
@Composable
private fun BasicHomeScreen(
    result: CourseLoadResult?,
    bundle: CourseBundle?,
    onOpenLesson: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    // نوع نتیجه Loader تعیین می‌کند صفحه چه Stateای را نشان دهد.
    when (result) {
        // null یعنی Coroutine هنوز در حال خواندن assets است.
        null -> Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CircularProgressIndicator()
        }

        // Failure خطای خواندن فایل یا I/O را گزارش می‌کند.
        is CourseLoadResult.Failure -> BasicMessage(
            message = "خطا در خواندن دوره: ${result.message}",
            modifier = modifier
        )

        // Invalid خطای Contract/Validator را به‌جای Crash به کاربر توسعه‌دهنده نشان می‌دهد.
        is CourseLoadResult.Invalid -> BasicMessage(
            message = "Course Package نامعتبر است:\n${result.errors.joinToString("\n")}",
            modifier = modifier
        )

        // Success فقط Bundle معتبر را برای ساخت فهرست درس‌ها مصرف می‌کند.
        is CourseLoadResult.Success -> LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header تعداد واقعی سطح، فصل و درس کامپایل‌شده را نشان می‌دهد.
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = bundle?.manifest?.titleFa.orEmpty(),
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Text(
                        text = "${bundle?.levels?.size ?: 0} سطح • ${bundle?.chapters?.size ?: 0} فصل • ${bundle?.lessons?.size ?: 0} درس آماده"
                    )
                    Text(
                        text = "از مبانی رایانه و حل مسئله شروع کنید؛ محتوای دوره مرحله‌به‌مرحله تا سطح تخصصی گسترش می‌یابد.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            // هر Lesson واقعی یک مقصد قابل لمس می‌گیرد و عنوان از JSON خوانده می‌شود.
            items(
                items = bundle?.lessons.orEmpty(),
                key = { lesson -> lesson.id }
            ) { lesson ->
                Button(
                    onClick = { onOpenLesson(lesson.id) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(lesson.title)
                }
            }

            // Padding انتهایی آخرین آیتم را از Navigation Bar دستگاه دور نگه می‌دارد.
            item {
                Column(modifier = Modifier.padding(bottom = 24.dp)) {}
            }
        }
    }
}

/** پیام تمام‌صفحه ساده برای خطاهای Loader و Stable ID نامعتبر. */
@Composable
private fun BasicMessage(
    message: String,
    modifier: Modifier = Modifier
) {
    // Column متن را در مرکز ناحیه محتوا قرار می‌دهد.
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(message)
    }
}
