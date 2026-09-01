from pathlib import Path


path = Path("app/src/main/kotlin/com/asdevelopers/academy/basic/BasicAcademyApp.kt")
text = path.read_text(encoding="utf-8")


IMPORT_REPLACEMENTS = {
    "import com.asdevelopers.academy.core.ui.components.AcademyDrawerItem\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiDrawerItem\n",
    "import com.asdevelopers.academy.core.ui.content.LessonRenderer\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiLessonScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademyAboutScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiAboutScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademyExerciseScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiExerciseScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademyFlashcardReviewScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiFlashcardReviewScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademyPlacementSummaryScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiPlacementSummaryScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademyProjectScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiProjectScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademyQuizScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiQuizScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademySettingsScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiSettingsScreen\n",
    "import com.asdevelopers.academy.core.ui.screens.AcademyWeakTopicReviewScreen\n":
        "import com.asdevelopers.academy.mainui.AcademyMainUiWeakTopicReviewScreen\n",
    "import com.asdevelopers.academy.core.ui.theme.DefaultAcademyBranding\n":
        "import com.asdevelopers.academy.mainui.DefaultMainUiBranding\n",
}

for old, new in IMPORT_REPLACEMENTS.items():
    count = text.count(old)
    if count != 1:
        raise SystemExit(f"Expected one import match for {old.strip()}, got {count}")
    text = text.replace(old, new, 1)

CALL_REPLACEMENTS = {
    "AcademyDrawerItem(": "AcademyMainUiDrawerItem(",
    "LessonRenderer(": "AcademyMainUiLessonScreen(",
    "AcademyAboutScreen(": "AcademyMainUiAboutScreen(",
    "AcademyExerciseScreen(": "AcademyMainUiExerciseScreen(",
    "AcademyFlashcardReviewScreen(": "AcademyMainUiFlashcardReviewScreen(",
    "AcademyPlacementSummaryScreen(": "AcademyMainUiPlacementSummaryScreen(",
    "AcademyProjectScreen(": "AcademyMainUiProjectScreen(",
    "AcademyQuizScreen(": "AcademyMainUiQuizScreen(",
    "AcademySettingsScreen(": "AcademyMainUiSettingsScreen(",
    "AcademyWeakTopicReviewScreen(": "AcademyMainUiWeakTopicReviewScreen(",
    "DefaultAcademyBranding": "DefaultMainUiBranding",
}

for old, new in CALL_REPLACEMENTS.items():
    count = text.count(old)
    if count == 0:
        raise SystemExit(f"Expected at least one call/value match for {old}")
    text = text.replace(old, new)

path.write_text(text, encoding="utf-8")
print("Basic shared screens now import only the MainUi presentation facade")
