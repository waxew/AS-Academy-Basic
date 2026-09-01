plugins {
    // AGP 9 provides the Android application toolchain used by the shared Academy builds.
    id("com.android.application")
    // Compose compiler stays aligned with Core/MainUi.
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    // Stable app identity must never change or Android would treat the update as a different application.
    namespace = "com.asdevelopers.academy.basic"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.asdevelopers.academy.basic"
        minSdk = 23
        targetSdk = 36
        // Release candidate for the 1.1 line; versionCode stays above the signed 1.0.0 release (versionCode 9).
        versionCode = 10
        versionName = "1.1.0-rc1"
    }

    // Basic remains only the Android entry host; reusable presentation belongs to MainUi.
    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Release variants remain unsigned in the public repository. Publish builds must use the existing Basic signing JKS.
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // Core 1.3 owns runtime, repositories, engines, persistence, navigation contracts and Course Package APIs.
    implementation("com.asdevelopers.academy:core:1.3.0")
    // MainUi is the visual/presentation dependency for shared Course App surfaces.
    implementation("com.asdevelopers.academy:main-ui:0.1.0")

    // Host-only Android dependencies are kept minimal.
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
