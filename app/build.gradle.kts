plugins {
    // AGP 9 provides the Android application and built-in Kotlin support used by the Core sample host.
    id("com.android.application")
    // Compose compiler version is kept aligned with the Core repository.
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    // Namespace and applicationId are stable identifiers; changing applicationId later would create a different app.
    namespace = "com.asdevelopers.academy.basic"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.asdevelopers.academy.basic"
        minSdk = 23
        targetSdk = 36
        // versionCode فقط افزایشی است تا APK جدید روی نسخه قبلی بدون حذف داده نصب شود.
        versionCode = 2
        // 0.2.0 اولین نسخه‌ای است که هر چهار سطح محتوایی Basic را در یک Package واحد دارد.
        versionName = "0.2.0"
    }

    // Basic is a Compose host; reusable UI remains inside AS-Academy-Core.
    buildFeatures {
        compose = true
        buildConfig = true
    }

    // Core and all AS Academy course hosts use JDK 17 bytecode compatibility.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Release builds are prepared for signing outside the public repository.
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // All shared learning/runtime behavior comes from the central composite build.
    // 1.0.1 شامل قرارداد سازگار EXERCISE_LINK و dependency عمومی Room برای Hostهای دوره است.
    implementation("com.asdevelopers.academy:core:1.0.1")

    // Host-only Android and Compose dependencies mirror the versions used by Core.
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.activity:activity-compose:1.12.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
    implementation("androidx.navigation:navigation-compose:2.9.6")

    implementation(platform("androidx.compose:compose-bom:2025.12.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
