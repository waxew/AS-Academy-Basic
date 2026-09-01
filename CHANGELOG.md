# Changelog

همه تغییرات قابل انتشار AS Academy Basic در این فایل ثبت می‌شوند. نسخه‌ها از Semantic Versioning پیروی می‌کنند.

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
