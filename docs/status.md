# وضعیت فعلی AS Academy Basic

آخرین بازبینی: 2026-09-01

## وضعیت انتشار

- Stable: `1.0.0` / `versionCode=9`
- Release Candidate: `1.1.0-rc2` / `versionCode=11`
- Android package: `com.asdevelopers.academy.basic`
- Signing identity: باید همان identity نسخه 1.0.0 باقی بماند.
- Stable `1.1.0`: هنوز منتشر نشده و به Upgrade/Smoke Test واقعی وابسته است.

## معماری چهارریپویی

- `AS-Academy-Core 1.4.0`: Runtime، Engine، Persistence، Navigation Contract و Runtime Content Update.
- `AS-Academy-MainUi 0.1.0`: Theme، AppShell، Home، Learning Catalog و Screenهای مشترک.
- `AS-Academy-MainCourse`: منبع یگانه محتوای آموزشی در `courses/basic/course` و ناشر کانال `basic-content`.
- `AS-Academy-Basic`: Thin Android Host؛ محتوای قابل ویرایش Course محلی ندارد.

Course Manifest مرکزی Basic:

- `version=1.1.0`
- `curriculumVersion=1.1.0`
- `minimumCoreVersion=1.3.0`
- `contentSchemaVersion=1`

## ورودی‌های قفل‌شده RC2

- Core: `38d54560e56479bd4e3d784dd1a9a65d8c9dd5fc`
- MainUi: `2519f76a1391e87dfbf784eb7c3b18c06868680b`
- MainCourse: `5c7f4d01a60d850d796bf7ec887b45c6aa495f28`

این Pinها باعث می‌شوند Build نسخه RC2 با حرکت branchهای مرکزی به‌صورت ناخواسته تغییر نکند.

## Runtime Content Channel

کانال عمومی Basic:

- Release tag: `basic-content`
- Metadata: `releases/download/basic-content/latest.json`
- Package: `releases/download/basic-content/basic-course.json`
- Package SHA-256 فعلی: `cfed3c452dbe2efc803e9f31de9f462467a1040bbb05688dcf00bc9ef2ca0e22`
- Package size فعلی: `1,553,478` bytes

رفتار Runtime:

`installed valid package -> bundled APK asset fallback -> UI -> background HTTPS check -> validate/install -> reload CourseBundle`

کنترل‌های قبل از فعال‌سازی:

- HTTPS-only
- SHA-256
- Course Validator
- `courseId`
- SemVer / downgrade protection
- `minimumCoreVersion`
- atomic install
- backup/rollback

Progress و داده‌های کاربر از Course Package جدا هستند و Content Update نباید آن‌ها را پاک کند.

## آمار محتوای واقعی

- سطح‌ها: **4**
- فصل‌ها: **39**
- درس‌ها: **157**
- Quizها: **73**
- سؤال‌ها: **534**
- Micro Quiz: **20 / 100 سؤال**
- Exerciseها: **195**
- Challenge Exercise: **40**
- Projectها: **14**
- Glossary Entry: **69**
- Placement Test: **1 / 32 سؤال**
- Depth Assessment: **4 / 80 سؤال**
- Interview Assessment: **5 / 100 سؤال**

توزیع درس‌ها:

- مبانی: **41 درس / 10 فصل**
- مقدماتی: **48 درس / 12 فصل**
- پیشرفته: **44 درس / 11 فصل**
- تخصصی و بازار کار: **24 درس / 6 فصل**

## قابلیت‌های فعال Android

- RTL و Theme/Settings مشترک
- Drawer و Back Navigation
- Home و Learning Catalog
- Lesson / Quiz / Exercise / Project
- Placement Summary
- Weak Topic Review
- Flashcard / Spaced Review
- Quiz History
- Exercise Draft/Completion
- Project Progress
- Room persistence مشترک
- Offline compiled Course Package
- Runtime Content Update مستقل از APK
- Final Capstone: `basic-prj-014`

## QA و Build Pipeline

Pipeline رسمی:

`MainCourse Validate -> Core Compile -> MainUi Lint/Build -> Basic Lint/Debug -> Basic unsigned Release -> SHA-256 -> Artifacts`

Gateهای Runtime Content نیز جداگانه در MainCourse اجرا می‌شوند:

`Validate -> Compile -> Generate metadata/SHA -> Verify hash -> Publish rolling content assets`

## Gateهای باقی‌مانده برای Stable 1.1.0

1. تکمیل CI نهایی RC2 و دریافت Debug/unsigned Release artifact.
2. تولید Signed RC2 با همان JKS خصوصی نسخه 1.0.0 و Verify certificate/signature.
3. نصب signed 1.0.0 و Upgrade مستقیم به RC2 روی Device/Emulator بدون حذف داده.
4. Smoke Test مسیرهای Home، Drawer، Catalog، Lesson، Quiz، Exercise، Project، Placement، Weak Topic Review و Flashcard Review.
5. Smoke Test Runtime Content Update و fallback آفلاین روی نصب واقعی.
6. ثبت SHA-256 و Verify نهایی Publish APK و سپس Tag/Release نسخه Stable.
