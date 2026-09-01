// Plugin repositories are defined once for the whole Basic Android host.
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

// Application dependencies must come from the same trusted repositories as the shared AS Academy builds.
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// Basic is now a thin Course App. Core owns runtime/engine and MainUi owns presentation.
rootProject.name = "AS-Academy-Basic"
include(":app")

// Shared runtime/engine source.
val academyCoreDir = System.getenv("ACADEMY_CORE_DIR") ?: "../AS-Academy-Core"
includeBuild(academyCoreDir)

// Shared visual/presentation source. UI changes must not be copied into this Course App.
val academyMainUiDir = System.getenv("ACADEMY_MAIN_UI_DIR") ?: "../AS-Academy-MainUi"
includeBuild(academyMainUiDir)
