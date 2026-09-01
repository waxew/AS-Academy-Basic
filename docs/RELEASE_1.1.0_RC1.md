# AS Academy Basic 1.1.0-rc1 Release Gate

این سند وضعیت قابل تکرار Release Candidate نسخه 1.1 را ثبت می‌کند.

## Identity

- applicationId: `com.asdevelopers.academy.basic`
- versionCode: `10`
- versionName: `1.1.0-rc1`
- previous stable: `1.0.0` / versionCode `9`
- signing identity: همان JKS خصوصی و پایدار نسخه `1.0.0`

## Frozen cross-repository inputs

- Core: `47b4c32ed2b4f707444f059f26b03ca4755dbfb4`
- MainUi: `2519f76a1391e87dfbf784eb7c3b18c06868680b`
- MainCourse: `de4001ccd55ff346bab420f86bfd7b8868806768`
- MainCourse Basic manifest: `version=1.1.0`, `curriculumVersion=1.1.0`, `minimumCoreVersion=1.3.0`

## Automated gates

- [x] Validate canonical MainCourse Basic Course Package
- [x] Compile MainCourse package into Android asset
- [x] MainUi lintDebug
- [x] MainUi assembleDebug
- [x] Basic lintDebug
- [x] Basic assembleDebug
- [x] Basic assembleRelease (unsigned QA artifact)
- [x] SHA-256 generated for Debug and unsigned Release artifacts

## RC signing identity evidence

- [x] همان JKS خصوصی نسخه 1.0.0 برای امضای یک RC test artifact استفاده شد.
- [x] امضای RC test artifact با `jarsigner` verify شد.
- [x] SHA-256 fingerprint گواهی RC test دقیقاً با signed 1.0.0 یکسان است.
- [x] package/version configuration برای RC روی `com.asdevelopers.academy.basic / versionCode=10 / versionName=1.1.0-rc1` ثابت شده است.

این RC test صرفاً برای Upgrade/Sideload verification است. Publish نهایی باید با Android APK signing مناسب و همین signing identity ساخته شود.

## Publish gates

- [ ] Sign final Publish APK with the exact same private JKS used for 1.0.0 using Android APK signing.
- [ ] Verify final Publish APK signature/certificate.
- [ ] Independently verify final APK package is `com.asdevelopers.academy.basic` and versionCode is greater than 9.
- [ ] Install/upgrade smoke test over signed 1.0.0 while preserving app data.
- [ ] Smoke test Home, Drawer, Learning Catalog, Lesson, Quiz, Exercise, Project, Placement, Weak Topic Review and Flashcard Review.
- [ ] Verify offline Course Package loads from compiled MainCourse asset on an installed build.
- [ ] Record final Publish APK SHA-256.

Stable `1.1.0` must not be tagged or published until all Publish gates pass.
