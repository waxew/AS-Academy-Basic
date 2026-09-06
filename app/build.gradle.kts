plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.asdevelopers.academy.basic"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.asdevelopers.academy.basic"
        minSdk = 23
        targetSdk = 36
        // RC3 migrates Basic to the Foundation v1.5 thin-host architecture.
        versionCode = 12
        versionName = "1.1.0-rc3"
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    // Foundation v1.5 runtime/composition root.
    implementation("com.asdevelopers.academy:core:1.5.0")
    // Shared presentation and compiled-course host.
    implementation("com.asdevelopers.academy:main-ui:0.1.0")

    // Host-only Android dependencies stay intentionally minimal.
    implementation("androidx.core:core-ktx:1.17.0")
    implementation("androidx.activity:activity-compose:1.12.2")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.10.0")

    implementation(platform("androidx.compose:compose-bom:2025.12.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.foundation:foundation")
    implementation("androidx.compose.material3:material3")
    debugImplementation("androidx.compose.ui:ui-tooling")
}
