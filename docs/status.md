# وضعیت فعلی AS Academy Basic

آخرین بازبینی: 2026-09-01

## وضعیت انتشار

- Stable: `1.0.0` / `versionCode=9`
- Release Candidate: `1.1.0-rc1` / `versionCode=10`
- Android package: `com.asdevelopers.academy.basic`
- Signing identity: بدون تغییر نسبت به 1.0.0
- Stable `1.1.0`: هنوز منتشر نشده و به Upgrade/Smoke Test واقعی وابسته است.

## معماری چهارریپویی

- `AS-Academy-Core 1.3.0`: Runtime، Engine، Persistence، Navigation Contract و منطق مشترک.
- `AS-Academy-MainUi 0.1.0`: Theme، AppShell، Home، Learning Catalog و Screenهای مشترک.
- `AS-Academy-MainCourse`: منبع یگانه محتوای آموزشی در `courses/basic/course`.
- `AS-Academy-Basic`: Thin Android Host؛ محتوای Course محلی ندارد.

Course Manifest مرکزی Basic:

- `version=1.1.0`
- `curriculumVersion=1.1.0`
- `minimumCoreVersion=1.3.0`
- `contentSchemaVersion=1`

## ورودی‌های قفل‌شده RC

- Core: `47b4c32ed2b4f707444f059f26b03ca4755dbfb4`
- MainUi: `2519f76a1391e87dfbf784eb7c3b18c06868680b`
- MainCourse: `de4001ccd55ff346bab420f86bfd7b8868806768`

این Pinها باعث می‌شوند Build نسخه RC با حرکت branchهای مرکزی به‌صورت ناخواسته تغییر نکند.

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
- Final Capstone: `basic-prj-014`

## QA و Build Pipeline

Pipeline رسمی:

`MainCourse Validate -> Core Compile -> MainUi Lint/Build -> Basic Lint/Debug -> Basic unsigned Release -> SHA-256 -> Artifacts`

وضعیت Release Candidate:

- MainCourse validator: موفق
- Compile محتوای canonical: موفق
- MainUi lint/build: موفق
- Basic lint/debug build: موفق
- Basic unsigned release build: موفق
- SHA-256 artifacts: موفق
- Signing certificate compatibility با signed 1.0.0: تأیید شده در تست محلی RC

## Gateهای باقی‌مانده برای Stable 1.1.0

1. تولید Publish APK با Android APK signing مناسب و همان JKS خصوصی نسخه 1.0.0.
2. نصب signed 1.0.0 و Upgrade مستقیم به 1.1.0 RC روی Device/Emulator بدون حذف داده.
3. Smoke Test مسیرهای Home، Drawer، Catalog، Lesson، Quiz، Exercise، Project، Placement، Weak Topic Review و Flashcard Review.
4. تأیید Load محتوای Offline از MainCourse روی نصب واقعی.
5. ثبت SHA-256 و Verify نهایی APK و سپس Tag/Release نسخه Stable.
