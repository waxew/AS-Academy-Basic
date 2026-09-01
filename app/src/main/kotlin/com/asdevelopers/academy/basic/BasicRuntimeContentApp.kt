package com.asdevelopers.academy.basic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.asdevelopers.academy.core.content.CourseLoadResult
import com.asdevelopers.academy.core.update.ContentInstallResult
import com.asdevelopers.academy.core.update.ContentUpdateCheckResult
import com.asdevelopers.academy.core.update.CourseContentStore
import com.asdevelopers.academy.core.update.CourseContentUpdater
import com.asdevelopers.academy.core.update.HttpsJsonContentUpdateProvider
import java.io.File

/**
 * Bootstrap محتوای Basic را مستقل از چرخه انتشار APK مدیریت می‌کند.
 *
 * ابتدا نسخه معتبر موجود روی دستگاه یا Asset داخل APK فعال می‌شود تا برنامه آفلاین بماند. سپس بررسی
 * HTTPS در پس‌زمینه همان coroutine انجام می‌شود؛ نصب موفق باعث Recreate شدن فقط درخت Compose دوره و
 * Load مجدد CourseBundle می‌شود، بدون حذف Room/DataStore یا Progress کاربر.
 */
@Composable
fun BasicRuntimeContentApp() {
    // Context برای مسیرهای private app storage، cache و دسترسی Asset لازم است.
    val context = LocalContext.current
    // Store عمومی Core مالک انتخاب installed package در برابر bundled asset است.
    val contentStore = remember {
        CourseContentStore(
            context = context,
            courseId = BASIC_RUNTIME_COURSE_ID,
            bundledAssetPath = BASIC_RUNTIME_ASSET_PATH
        )
    }
    // تا قبل از فعال شدن منبع محلی معتبر، UI آموزشی ساخته نمی‌شود.
    var localContentReady by remember { mutableStateOf(false) }
    // هر نصب موفق generation را بالا می‌برد تا BasicAcademyApp CourseBundle جدید را دوباره Load کند.
    var contentGeneration by remember { mutableIntStateOf(0) }

    LaunchedEffect(Unit) {
        // این مرحله فقط از Storage/Asset محلی می‌خواند و به اینترنت وابسته نیست.
        val initialSnapshot = contentStore.loadAndActivatePreferred()
        val currentVersion = (initialSnapshot.result as? CourseLoadResult.Success)
            ?.bundle
            ?.manifest
            ?.version

        // محتوای فعلی بلافاصله قابل نمایش می‌شود؛ Check شبکه بعد از این State انجام می‌شود.
        localContentReady = true

        // Provider عمومی Core فقط Metadata و Package رسمی MainCourse را از HTTPS دریافت می‌کند.
        val updater = CourseContentUpdater(
            provider = HttpsJsonContentUpdateProvider(BASIC_RUNTIME_METADATA_URL),
            installer = contentStore.updateManager(),
            downloadDirectory = File(context.cacheDir, "academy-content-downloads/basic")
        )

        // شکست اینترنت/Metadata/Download برنامه را متوقف نمی‌کند؛ نسخه فعلی فعال باقی می‌ماند.
        when (
            val update = updater.checkAndInstall(
                courseId = BASIC_RUNTIME_COURSE_ID,
                currentVersion = currentVersion
            )
        ) {
            is ContentUpdateCheckResult.Completed -> {
                // فقط نصب واقعی نسخه جدید باعث Refresh UI می‌شود؛ ALREADY_CURRENT و Reject تغییری نمی‌دهند.
                if (update.install is ContentInstallResult.Installed) {
                    val refreshed = contentStore.loadAndActivatePreferred()
                    if (refreshed.result is CourseLoadResult.Success) {
                        contentGeneration += 1
                    }
                }
            }
            is ContentUpdateCheckResult.Failed,
            ContentUpdateCheckResult.NoRelease -> Unit
        }
    }

    if (!localContentReady) {
        // Loading کوتاه فقط برای Resolve/Validate محتوای محلی است و منتظر شبکه نمی‌ماند.
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        // Host اصلی بدون Fork محتوا باقی می‌ماند و از AssetCoursePackageSource موجود استفاده می‌کند.
        // Core 1.4 override معتبر نصب‌شده را برای همان assetPath به‌صورت شفاف در اختیار آن می‌گذارد.
        key(contentGeneration) {
            BasicAcademyApp()
        }
    }
}

/** Stable Course ID کانال Runtime باید با manifest MainCourse یکسان بماند. */
private const val BASIC_RUNTIME_COURSE_ID = "basic"

/** Asset آفلاین همچنان در هر APK وجود دارد و آخرین fallback قطعی برنامه است. */
private const val BASIC_RUNTIME_ASSET_PATH = "basic-course.json"

/** Metadata کانال Rolling عمومی MainCourse؛ خود Package از downloadUrl داخل این فایل دریافت می‌شود. */
private const val BASIC_RUNTIME_METADATA_URL =
    "https://github.com/waxew/AS-Academy-MainCourse/releases/download/basic-content/latest.json"
