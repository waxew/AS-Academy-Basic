# Changelog

همه تغییرات قابل انتشار AS Academy Basic در این فایل ثبت می‌شوند. نسخه‌ها از Semantic Versioning پیروی می‌کنند.

## 1.1.0-rc2 — 2026-09-01

### Added

- Runtime Content Update مستقل از APK با استفاده از `AS-Academy-Core 1.4.0`.
- `BasicRuntimeContentApp` برای فعال‌سازی نسخه معتبر محلی و بررسی کانال رسمی MainCourse در پس‌زمینه.
- کانال Metadata عمومی `basic-content/latest.json` برای کشف نسخه جدید Course Package.
- fallback قطعی به `basic-course.json` داخل APK در نبود اینترنت یا رد شدن Update.

### Changed

- `MainActivity` از Bootstrap محتوایی جدید شروع می‌شود و سپس Host اصلی Basic را اجرا می‌کند.
- `versionCode` از 10 به 11 و `versionName` از `1.1.0-rc1` به `1.1.0-rc2` افزایش یافت.
- Runtime/Engine از Core 1.3.0 به Core 1.4.0 ارتقا یافت.
- Permission استاندارد `INTERNET` برای دریافت محتوای آموزشی از HTTPS اضافه شد؛ Storage permission عمومی اضافه نشده است.
- Content Update موفق فقط درخت Compose دوره را Reload می‌کند؛ Room/DataStore و Progress کاربر حذف یا Reset نمی‌شوند.

### Safety

- SHA-256، Course Validator، `courseId`، SemVer و `minimumCoreVersion` قبل از فعال شدن Package جدید بررسی می‌شوند.
- نصب Package به‌صورت Atomic انجام می‌شود و Core Backup/Rollback را نگه می‌دارد.
- Update خراب، ناقص، قدیمی یا ناسازگار جایگزین محتوای فعال نمی‌شود.
- `applicationId` همچنان `com.asdevelopers.academy.basic` است و Signing identity نسخه Stable 1.0.0 نباید تغییر کند.

## 1.1.0-rc1 — 2026-09-01

### Changed

- تبدیل `AS-Academy-Basic` به Thin Android Host در معماری چهارریپویی Academy.
- انتقال منبع اصلی Course Package به `AS-Academy-MainCourse/courses/basic/course` و حذف کپی محلی محتوا از Host.
- انتقال Presentation مشترک به `AS-Academy-MainUi 0.1.0`.
- ارتقا Runtime/Engine به `AS-Academy-Core 1.3.0`.
- هم‌راستا شدن Course Manifest مرکزی با `version=1.1.0`، `curriculumVersion=1.1.0` و `minimumCoreVersion=1.3.0`.
- فعال شدن Learning Catalog برای دسترسی مستقیم به Quiz، Exercise و Project.
- CI یکپارچه چهاربخشی برای Validate/Compile محتوای MainCourse، Build/Lint MainUi و Build/Lint Host.

### Release candidate notes

- `applicationId`: `com.asdevelopers.academy.basic` بدون تغییر باقی مانده است.
- `versionCode`: 10؛ بالاتر از نسخه 1.0.0 با `versionCode=9`.
- `versionName`: `1.1.0-rc1`.
- Release عمومی repository همچنان unsigned است؛ Publish APK نهایی باید فقط با همان JKS خصوصی نسخه 1.0.0 امضا شود تا Update روی نسخه قبلی معتبر بماند.
- RC قبل از Stable 1.1.0 باید از QA چهارریپویی، نصب/Upgrade smoke test و verify امضا عبور کند.

## 1.0.0 — 2026-08-30

### Added

- چهار سطح کامل آموزشی: مبانی، مقدماتی، پیشرفته و تخصصی/بازار کار.
- 39 فصل و 157 درس واقعی با Stable ID.
- 73 Quiz با مجموع 534 سؤال، شامل Placement، Depth Assessment، Micro Quiz و Interview Bank.
- 195 Exercise با Hint/Solution/Explanation و 40 Challenge چندموضوعی.
- 14 Project چندمرحله‌ای و Final Capstone.
- 69 Glossary entry برای واژه‌نامه و Flashcard seed.
- Placement Test جامع 32 سؤالی و مسیر شروع سطح پیشنهادی.
- Weak Topic Review، Flashcard/Spaced Review و persistence مشترک از AS Academy Core.
- Android Host مستقل با RTL، Theme/Settings، Drawer، Back navigation و Room persistence مشترک.
- CI برای Validate Course Package، Compile Bundle، Lint و APK build.

### Release notes

- نخستین نسخه Stable دوره Basic.
- `applicationId`: `com.asdevelopers.academy.basic` ثابت و مناسب Upgradeهای بعدی است.
- `versionCode`: 9.
- `versionName`: 1.0.0.
- `minimumCoreVersion`: 1.2.0.
- Release APK با کلید خصوصی پایدار AS Academy خارج از repository عمومی امضا می‌شود.
