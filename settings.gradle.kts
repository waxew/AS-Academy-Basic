// Plugin repositories are defined once for the whole Basic Android host.
pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

// Application dependencies must come from the same trusted repositories as AS-Academy-Core.
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

// The course has its own Android host while shared runtime modules remain in AS-Academy-Core.
rootProject.name = "AS-Academy-Basic"
include(":app")

// Developers normally keep both repositories next to each other.
// CI can override the path with ACADEMY_CORE_DIR without changing source files.
val academyCoreDir = System.getenv("ACADEMY_CORE_DIR") ?: "../AS-Academy-Core"
includeBuild(academyCoreDir)
