from pathlib import Path


path = Path("app/src/main/kotlin/com/asdevelopers/academy/basic/BasicAcademyApp.kt")
text = path.read_text(encoding="utf-8")


def replace_once(old: str, new: str, label: str) -> None:
    global text
    count = text.count(old)
    if count != 1:
        raise SystemExit(f"{label}: expected exactly one match, got {count}")
    text = text.replace(old, new, 1)


# Public presentation entry points now come from MainUi; Core remains runtime/navigation/data.
replace_once(
    "import com.asdevelopers.academy.core.ui.components.AcademyAppShell\n",
    "import com.asdevelopers.academy.mainui.AcademyMainUiShell\n",
    "AppShell import",
)
replace_once(
    "import com.asdevelopers.academy.core.ui.theme.AcademyTheme\n",
    "import com.asdevelopers.academy.mainui.AcademyMainUiTheme\n",
    "Theme import",
)
replace_once(
    "import com.asdevelopers.academy.core.navigation.openLesson\n",
    "import com.asdevelopers.academy.core.navigation.openLesson\n"
    "import com.asdevelopers.academy.core.navigation.openLearningCatalog\n",
    "Catalog navigation import",
)
replace_once(
    "import com.asdevelopers.academy.core.ui.theme.DefaultAcademyBranding\n",
    "import com.asdevelopers.academy.core.ui.theme.DefaultAcademyBranding\n"
    "import com.asdevelopers.academy.mainui.AcademyCourseHomeScreen\n"
    "import com.asdevelopers.academy.mainui.AcademyCourseLearningCatalog\n"
    "import com.asdevelopers.academy.mainui.AcademyMainUiLoading\n"
    "import com.asdevelopers.academy.mainui.AcademyMainUiMessage\n",
    "MainUi facade imports",
)

replace_once("    AcademyTheme(\n", "    AcademyMainUiTheme(\n", "Theme call")
replace_once("            AcademyAppShell(\n", "            AcademyMainUiShell(\n", "AppShell call")

# Catalog becomes a first-class visible action rather than an unreachable Core 1.3 route.
catalog_drawer = """        AcademyDrawerItem(
            id = \"basic-catalog\",
            label = \"تمرین، آزمون و پروژه\",
            icon = Icons.Outlined.MenuBook
        ) {
            navController.openLearningCatalog()
        },
"""
marker = """        AcademyDrawerItem(
            id = \"basic-flashcards\",
"""
replace_once(marker, catalog_drawer + marker, "Catalog drawer item")

replace_once(
    """                            onOpenFlashcards = { navController.openFlashcardReview() },
                            modifier = Modifier.padding(paddingValues)
""",
    """                            onOpenFlashcards = { navController.openFlashcardReview() },
                            onOpenCatalog = { navController.openLearningCatalog() },
                            modifier = Modifier.padding(paddingValues)
""",
    "Home catalog callback",
)

# Add the shared catalog route after the existing spaced-review destination.
nav_tail = """                                )
                            }
                        }
                    }
                )
"""
nav_with_catalog = """                                )
                            }
                        }
                    },
                    learningCatalog = {
                        val currentBundle = bundle
                        if (currentBundle == null) {
                            AcademyMainUiMessage(
                                message = \"Course هنوز بارگذاری نشده است.\",
                                modifier = Modifier.padding(paddingValues)
                            )
                        } else {
                            AcademyCourseLearningCatalog(
                                bundle = currentBundle,
                                onQuizClick = { quizId -> navController.openQuiz(quizId) },
                                onExerciseClick = { exerciseId -> navController.openExercise(exerciseId) },
                                onProjectClick = { projectId -> navController.openProject(projectId) },
                                modifier = Modifier.padding(paddingValues)
                            )
                        }
                    }
                )
"""
replace_once(nav_tail, nav_with_catalog, "Learning Catalog destination")

# Replace Course-specific duplicated Home rendering with the shared data-driven MainUi surface.
start_marker = "/** صفحه خانه Basic داده را از Bundle می‌خواند و با اضافه شدن درس‌ها بدون تغییر کد رشد می‌کند. */"
end_marker = "/** پیام تمام‌صفحه ساده برای خطاهای Loader و Stable ID نامعتبر. */"
start = text.find(start_marker)
end = text.find(end_marker)
if start < 0 or end < 0 or end <= start:
    raise SystemExit("Could not locate BasicHomeScreen boundaries")

shared_home = """/** صفحه خانه Basic اکنون فقط State بارگذاری را به Home مشترک MainUi تبدیل می‌کند. */
@Composable
private fun BasicHomeScreen(
    result: CourseLoadResult?,
    bundle: CourseBundle?,
    onOpenLesson: (String) -> Unit,
    onOpenPlacement: () -> Unit,
    onOpenWeakReview: () -> Unit,
    onOpenFlashcards: () -> Unit,
    onOpenCatalog: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (result) {
        null -> AcademyMainUiLoading(modifier = modifier)
        is CourseLoadResult.Failure -> AcademyMainUiMessage(
            message = \"خطا در خواندن دوره: ${result.message}\",
            modifier = modifier
        )
        is CourseLoadResult.Invalid -> AcademyMainUiMessage(
            message = \"Course Package نامعتبر است:\\n${result.errors.joinToString(\"\\n\")}\",
            modifier = modifier
        )
        is CourseLoadResult.Success -> AcademyCourseHomeScreen(
            bundle = bundle ?: result.bundle,
            onOpenLesson = onOpenLesson,
            onOpenPlacement = onOpenPlacement,
            onOpenWeakReview = onOpenWeakReview,
            onOpenFlashcards = onOpenFlashcards,
            onOpenLearningCatalog = onOpenCatalog,
            modifier = modifier
        )
    }
}

"""
text = text[:start] + shared_home + text[end:]

# Even generic Course errors use the MainUi common state instead of a Basic-only visual component.
old_message = """@Composable
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
"""
new_message = """@Composable
private fun BasicMessage(
    message: String,
    modifier: Modifier = Modifier
) {
    AcademyMainUiMessage(message = message, modifier = modifier)
}
"""
replace_once(old_message, new_message, "Generic message migration")

path.write_text(text, encoding="utf-8")
print("BasicAcademyApp.kt migrated to MainUi presentation boundary")
