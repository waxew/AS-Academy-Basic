# AS Academy Basic

`Basic` دوره پایه و پیش‌نیاز مشترک برنامه‌نویسی در AS Academy است. این دوره قبل از Python، Java، Kotlin، C، C++، C#، JavaScript، PHP و دوره‌های بعدی قرار می‌گیرد و مفاهیم مشترک برنامه‌نویسی و مهندسی نرم‌افزار را از صفر تا آمادگی ورود به بازار کار آموزش می‌دهد.

## هویت پروژه

- App: **Basic**
- Repository: `AS-Academy-Basic`
- Course ID: `basic`
- Android package/applicationId: `com.asdevelopers.academy.basic`
- زبان اصلی: فارسی / RTL
- Android: `minSdk 23` / `targetSdk 36`
- Java: JDK 17
- Runtime/Engine: **AS-Academy-Core 1.4.0**
- Shared UI: **AS-Academy-MainUi 0.1.0**
- Canonical content: `AS-Academy-MainCourse/courses/basic/course`
- Stable release: **1.0.0**
- Current release candidate: **1.1.0-rc2**
- Android `versionCode`: **11**

## قانون معماری

این Repository یک **Thin Android Course Host** است. محتوای آموزشی Basic در این ریپو ویرایش یا Fork نمی‌شود.

مالکیت اجزا:

```text
AS-Academy-MainCourse
  -> درس، فصل، Quiz، Exercise، Project، Glossary و Curriculum

AS-Academy-Core
  -> Course contract/validator/compiler
  -> Runtime content updater
  -> SHA-256 / SemVer / minimumCoreVersion
  -> atomic install / backup / rollback
  -> Room / Progress / Placement / Review / Navigation contracts

AS-Academy-MainUi
  -> Theme / AppShell / Home / Catalog
  -> Lesson / Quiz / Exercise / Project
  -> Settings / About / Placement / Review UI

AS-Academy-Basic
  -> applicationId / versionCode / signing identity
  -> Branding و اتصال Course
  -> Android entry point
```

## آموزش‌ها بعد از انتقال به MainCourse چگونه داخل برنامه نمایش داده می‌شوند؟

انتقال Course به MainCourse به معنی حذف آموزش از اپ نیست. MainCourse فقط **Single Source of Truth** است.

در Build:

```text
AS-Academy-MainCourse/courses/basic/course
        |
        | Core Validate
        v
   valid Course Package
        |
        | Core Compile
        v
AS-Academy-Basic/app/src/main/assets/basic-course.json
        |
        v
       APK
```

در Runtime، Host فایل فعال Course را با `CoursePackageLoader` به `CourseBundle` تبدیل می‌کند و همان Bundle وارد MainUi می‌شود. در نتیجه این موارد از MainCourse دوباره داخل خود برنامه قابل نمایش و اجرا هستند:

- Level و Chapter
- Lesson و محتوای متنی/کد/مثال
- Quiz و Assessment
- Exercise و Challenge
- Project و Capstone
- Glossary و Flashcard seed
- Placement و Weak Topic Review
- Learning Catalog

بنابراین Course App همچنان یک برنامه آموزشی کامل و آفلاین است؛ فقط منبع ویرایش محتوا از Host جدا شده است.

## Runtime Content Update مستقل از APK

از `1.1.0-rc2`، Basic علاوه بر Asset داخل APK به کانال رسمی Runtime Content در MainCourse متصل است. در نتیجه برای اصلاح یا افزودن درس/آزمون/تمرین/پروژه، در صورتی که Schema و Runtime فعلی کافی باشند، لازم نیست APK جدید منتشر شود.

کانال رسمی:

```text
Metadata:
https://github.com/waxew/AS-Academy-MainCourse/releases/download/basic-content/latest.json

Package:
https://github.com/waxew/AS-Academy-MainCourse/releases/download/basic-content/basic-course.json
```

جریان اجرای برنامه:

```text
MainActivity
   |
   v
BasicRuntimeContentApp
   |
   +--> CourseContentStore
   |      |
   |      +--> installed valid course-package.json
   |      |
   |      `--> bundled basic-course.json in APK
   |
   +--> BasicAcademyApp -> CoursePackageLoader -> CourseBundle -> MainUi
   |
   `--> HTTPS latest.json check
          |
          +--> newer? download candidate
          |
          +--> SHA-256
          +--> Course Validator
          +--> courseId check
          +--> SemVer/downgrade check
          +--> minimumCoreVersion check
          |
          `--> atomic install -> activate -> reload CourseBundle
```

### ترتیب نمایش و Update

1. ابتدا `CourseContentStore` محتوای معتبر موجود روی دستگاه را Resolve می‌کند.
2. اگر قبلاً Content Update معتبر نصب شده باشد، همان فعال می‌شود.
3. در غیر این صورت `basic-course.json` داخل APK فعال می‌شود.
4. UI آموزشی بدون انتظار برای شبکه ساخته می‌شود.
5. سپس کانال MainCourse در پس‌زمینه بررسی می‌شود.
6. اگر نسخه جدید معتبر باشد، در فضای خصوصی اپ نصب و فعال می‌شود.
7. Host دوباره CourseBundle را Load می‌کند و محتوای جدید در MainUi نمایش داده می‌شود.

### رفتار آفلاین و خطا

این قابلیت **Offline-First** است. موارد زیر نباید باعث حذف آموزش یا غیرقابل استفاده شدن برنامه شوند:

- نبود اینترنت
- HTTP/Download failure
- Metadata خراب
- فایل ناقص
- SHA-256 اشتباه
- Course Package نامعتبر
- `courseId` اشتباه
- Downgrade
- `minimumCoreVersion` بالاتر از Core نصب‌شده

در تمام این حالات محتوای فعال فعلی باقی می‌ماند. اگر فایل نصب‌شده روی دستگاه خراب شود، Core آن را قرنطینه کرده و Asset آفلاین داخل APK را دوباره فعال می‌کند.

### امنیت و حفاظت از داده کاربر

Runtime Content Update فقط فایل Course Package را تعویض می‌کند. این داده‌ها جداگانه در Room/DataStore باقی می‌مانند:

- Progress
- Quiz History
- Exercise Draft/Completion
- Project Progress
- Placement Result
- Flashcard Progress
- Settings
- Profile

Package جدید قبل از فعال شدن با SHA-256 و Validator رسمی Core بررسی می‌شود. نصب Atomic است و Backup/Rollback در Core نگهداری می‌شود. Storage permission عمومی برای این قابلیت وجود ندارد.

## قانون نسخه محتوا

هر تغییر آموزشی که باید به کاربران نصب‌شده برسد باید در این فایل انجام شود:

```text
AS-Academy-MainCourse/courses/basic/course/manifest.json
```

و مقدار `version` افزایش یابد؛ مثلاً:

```text
1.1.0 -> 1.1.1
```

اگر فقط Course Content تغییر کرده باشد، افزایش `versionCode` اپ لازم نیست. اگر Core/UI/native capability/permission یا خود APK تغییر کند، App Update جداگانه لازم است.

خلاصه:

```text
Content Update = MainCourse version
App Update     = Android versionCode/versionName
```

## وضعیت واقعی محتوا

- **4 سطح**
- **39 فصل**
- **157 درس واقعی**
- **73 Quiz**
- **534 سؤال** با Explanation و Tag موضوعی
- **20 Micro Quiz** / 100 سؤال
- **195 Exercise** با Hint/Solution/Explanation
- **40 Challenge Exercise چندموضوعی**
- **14 Project** چندمرحله‌ای
- **69 Glossary Entry**
- **1 Placement Test** / 32 سؤال
- **4 Depth Assessment** / 80 سؤال
- **5 Interview Assessment** / 100 سؤال
- Final Capstone: `basic-prj-014`

توزیع درس‌ها:

- مبانی: **41 درس / 10 فصل**
- مقدماتی: **48 درس / 12 فصل**
- پیشرفته: **44 درس / 11 فصل**
- تخصصی: **24 درس / 6 فصل**

## چرخه آموزشی

```text
Placement
-> Learn
-> Example
-> Practice
-> Micro Quiz
-> Quiz
-> Weak Topic Review
-> Challenge
-> Project
-> Exam
-> Spaced Review
-> Interview Defense
```

## یادگیری تطبیقی

Host به قابلیت‌های مشترک Core متصل است:

- `basic-qz-placement-001` برای تعیین سطح
- `PlacementResultRepository`
- `PlacementEngine.fourLevelPolicy()`
- `LearningPathEngine.firstLessonIdForLevelType()`
- `WeakTopicReviewRepository`
- Glossary به‌عنوان منبع Flashcard
- `FlashcardReviewRepository`
- Spaced Review با Again/Hard/Good/Easy
- Backup/Restore برنامه مرور و Progress

## پروژه نهایی

`basic-prj-014` یک **Personal Operations Manager** است و Problem/Scope، Data Model، Algorithm، Architecture، Offline Storage، Migration، Backup/Restore، Security، Git/PR، Testing، CI/CD، Release Evidence، Documentation، Performance Review، Portfolio Case Study و Mock Interview Defense را یکپارچه می‌کند.

## Android و QA

- Theme/AppShell/Home/Catalog و Lesson/Quiz/Exercise/Project/Settings/Review از MainUi استفاده می‌کنند.
- Course Package در CI فقط از MainCourse گرفته می‌شود.
- Core/MainUi/MainCourse در RC به SHAهای immutable قفل می‌شوند.
- CI مسیر `MainCourse -> Core -> MainUi -> Basic` را Validate/Lint/Build می‌کند.
- Debug و unsigned Release APK همراه SHA-256 به Artifact تبدیل می‌شوند.
- Release عمومی repository unsigned است.
- Publish APK نهایی باید فقط با همان JKS خصوصی Stable 1.0.0 امضا شود.
- `applicationId` ثابت `com.asdevelopers.academy.basic` است.
- Stable `1.1.0` تا Upgrade Test واقعی از Signed 1.0.0 و Smoke Test نهایی منتشر نمی‌شود.

## فایل‌های Runtime Content در این Host

```text
app/src/main/kotlin/com/asdevelopers/academy/basic/BasicRuntimeContentApp.kt
  -> bootstrap محتوای محلی + check/install/reload

app/src/main/kotlin/com/asdevelopers/academy/basic/MainActivity.kt
  -> اجرای BasicRuntimeContentApp

app/src/main/kotlin/com/asdevelopers/academy/basic/BasicAcademyApp.kt
  -> نمایش CourseBundle و اتصال همه Screenها

app/src/main/AndroidManifest.xml
  -> INTERNET + notification permission

.github/workflows/ci.yml
  -> compile Asset از MainCourse و QA چهارریپویی
```

## Build

چیدمان توسعه چهار Repository هم‌سطح است:

```text
AS-Academy-Core/
AS-Academy-MainUi/
AS-Academy-MainCourse/
AS-Academy-Basic/
```

Linux/macOS:

```bash
./scripts/prepare-course.sh
../AS-Academy-Core/gradlew -p . :app:assembleDebug :app:assembleRelease
```

Windows:

```bat
scripts\prepare-course.bat
..\AS-Academy-Core\gradlew.bat -p . :app:assembleDebug :app:assembleRelease
```

## Version History

### 1.1.0-rc2 — Runtime Content Update

- Core 1.4.0
- Android `versionCode=11`
- Android `versionName=1.1.0-rc2`
- Runtime Content Update مستقل از APK
- HTTPS MainCourse channel
- SHA-256/Validation/SemVer/Core compatibility gates
- Atomic install + backup/rollback
- installed-content-first + bundled asset fallback
- Refresh CourseBundle بعد از نصب موفق

### 1.1.0-rc1 — Four-repository migration

- MainCourse به‌عنوان Single Source of Truth
- MainUi 0.1.0
- Core 1.3.0
- Learning Catalog
- `versionCode=10 / versionName=1.1.0-rc1`
- CI چهارریپویی و dependency pinning

### 1.0.0 — Stable

- 157 درس، 73 Quiz، 534 سؤال، 195 Exercise و 14 Project
- Placement، Weak Topic Review و Spaced Review
- Final Capstone و Interview Bank
- `versionCode=9 / versionName=1.0.0`

## وضعیت فعلی

`1.0.0 stable / 1.1.0-rc2 development candidate / content source = MainCourse 1.1.0 / presentation = MainUi 0.1.0 / runtime = Core 1.4.0 / runtime content channel = basic-content`
