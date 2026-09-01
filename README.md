# AS Academy Basic

`Basic` دوره پایه و پیش‌نیاز مشترک برنامه‌نویسی در AS Academy است. این دوره قبل از Python، Java، Kotlin، C، C++، C#، JavaScript، PHP و دوره‌های بعدی قرار می‌گیرد و مفاهیم مشترک برنامه‌نویسی و مهندسی نرم‌افزار را از صفر تا آمادگی ورود به بازار کار آموزش می‌دهد.

## هویت پروژه

- App: **Basic**
- Repository: `AS-Academy-Basic`
- Course ID: `basic`
- Android package: `com.asdevelopers.academy.basic`
- زبان اصلی: فارسی / RTL
- Android: `minSdk 23` / `targetSdk 36`
- Java: JDK 17
- Core runtime: `AS-Academy-Core 1.3.0`
- Shared UI: `AS-Academy-MainUi 0.1.0`
- Canonical content: `AS-Academy-MainCourse/courses/basic/course`
- Stable release: **1.0.0**
- Current migration line: **1.1.0-dev**
- Android `versionCode`: **10**

## قانون معماری

این Repository از معماری جدید به بعد یک **Thin Course Host** است. محتوای آموزشی Basic فقط در `AS-Academy-MainCourse/courses/basic/course` نگهداری می‌شود؛ Presentation مشترک شامل Theme، AppShell، Home، Catalog، Lesson، Quiz، Exercise، Project، Settings و Reviewها از `AS-Academy-MainUi` مصرف می‌شود؛ Engine، Navigation contract، Room، Progress، Quiz/Exercise/Project logic، Placement، Weak Topic Review و Spaced Review در `AS-Academy-Core` باقی می‌مانند. پوشه `course/basic` در این Repository فقط Snapshot تاریخی 1.0.0 است و منبع ویرایش محتوای جدید نیست.

## چرخه آموزشی

`Placement -> Learn -> Example -> Practice -> Micro Quiz -> Quiz -> Weak Topic Review -> Challenge -> Project -> Exam -> Spaced Review -> Interview Defense`

## چهار سطح

1. **مبانی** — سواد رایانه، بازار کار، حل مسئله، الگوریتم، داده، عملگر، I/O، شرط، حلقه و تابع.
2. **مقدماتی** — Collection، String، Date/Time، Error، File، JSON/CSV/XML، CLI، Git، Debugging، Testing و Documentation.
3. **پیشرفته** — OOP، Functional، Recursion، Data Structures، Search/Sort، Complexity، Memory، Advanced Testing، Clean Code، Refactoring، SOLID و Patterns.
4. **تخصصی و بازار کار** — Architecture، Dependency/Versioning، Security، Agile/Review، CI/CD، Open Source، Portfolio و Technical Interview.

## وضعیت واقعی محتوای نسخه 1.0.0

- **4 سطح**
- **39 فصل**
- **157 درس واقعی**
- **73 Quiz**
- **534 سؤال** با Explanation و Tag موضوعی
- **20 Micro Quiz**، هرکدام 5 سؤال
- **195 Exercise** با Hint/Solution/Explanation
- **40 Challenge Exercise چندموضوعی**
- **14 Project** چندمرحله‌ای
- **69 Glossary Entry** برای واژه‌نامه و Flashcard seed
- **1 Placement Test** جامع 32 سؤالی
- **4 Depth Assessment** با مجموع 80 سؤال
- **5 Interview Assessment** با مجموع 100 سؤال

توزیع درس‌ها:

- مبانی: **41 درس / 10 فصل**
- مقدماتی: **48 درس / 12 فصل**
- پیشرفته: **44 درس / 11 فصل**
- تخصصی: **24 درس / 6 فصل**

## Micro Quizها

Micro Quizها برای تشخیص سریع ضعف قبل از آزمون جامع ساخته شده‌اند. هر سطح پنج Micro Quiz دارد و همه از درس جمع‌بندی همان سطح قابل بازشدن‌اند.

### مبانی

- `basic-qz-micro-fnd-001` — داده و عملگرها
- `basic-qz-micro-fnd-002` — ورودی و Validation
- `basic-qz-micro-fnd-003` — شرط و تصمیم
- `basic-qz-micro-fnd-004` — حلقه و State
- `basic-qz-micro-fnd-005` — Function و Decomposition

### مقدماتی

- `basic-qz-micro-beg-001` — Collection و String
- `basic-qz-micro-beg-002` — Date/Time و Error Handling
- `basic-qz-micro-beg-003` — File و Data Format
- `basic-qz-micro-beg-004` — CLI و Git
- `basic-qz-micro-beg-005` — Debug، Test و Documentation

### پیشرفته

- `basic-qz-micro-adv-001` — OOP و Functional
- `basic-qz-micro-adv-002` — Recursion و Data Structure
- `basic-qz-micro-adv-003` — Search، Sort و Complexity
- `basic-qz-micro-adv-004` — Memory و Testing
- `basic-qz-micro-adv-005` — Clean Code، SOLID و Pattern

### تخصصی

- `basic-qz-micro-spc-001` — Architecture و Versioning
- `basic-qz-micro-spc-002` — Security
- `basic-qz-micro-spc-003` — Teamwork، Agile و Review
- `basic-qz-micro-spc-004` — CI/CD و Open Source
- `basic-qz-micro-spc-005` — Portfolio و Interview

تمام Micro Quizها Passing Score برابر 80٪، Question/Answer Shuffle، Explanation و weak-topic tag دارند؛ بنابراین Attemptهای آن‌ها نیز وارد Quiz History و Weak Topic Review می‌شوند.

## Interview Bank

صد سؤال در پنج آزمون:

- `basic-qz-interview-001` — Problem Solving و Algorithms
- `basic-qz-interview-002` — Code Design، OOP و Data Structures
- `basic-qz-interview-003` — Debugging، Testing و Git
- `basic-qz-interview-004` — Architecture، Security و Delivery
- `basic-qz-interview-005` — System Design، Behavioral و Career

هر پنج آزمون از درس نهایی `basic-spc-024` قابل اجرا هستند.

## Challenge Bank

Exerciseهای `basic-ex-156` تا `basic-ex-195` چهل Challenge زبان‌خنثی هستند:

- 10 مبانی: validation، rules، statistics، state، ATM، password، inventory و گزارش مالی
- 10 مقدماتی: CSV/JSON، migration، timezone، file recovery، CLI، Git conflict، debugging، test matrix، API contract و Backup/Restore
- 10 پیشرفته: OOP/Composition، Functional Core، Recursion/Tree، Graph، Index، Search/Sort، Big-O، Memory، Test Architecture و Refactoring
- 10 تخصصی: ADR، Dependency Policy، Threat Model، AuthN/AuthZ، Code Review، Incident، CI/CD، Open Source، Portfolio و System Design

تمام Challengeها از درس جمع‌بندی سطح مربوط قابل بازشدن‌اند.

## پروژه‌ها و Final Capstone

چهارده پروژه مرحله‌ای از پروژه شروع مسیر تا Final Capstone وجود دارد. پروژه نهایی `basic-prj-014` یک **Personal Operations Manager** است و باید Problem/Scope، Data Model، Algorithm، Architecture، Offline Storage، Migration، Backup/Restore، Security، Git/PR، Testing، CI/CD، Release Evidence، Documentation، Performance Review، Portfolio Case Study و Mock Interview Defense را یکپارچه کند.

ارزیابی پروژه‌ها با `docs/PROJECT_RUBRIC.md` و `acceptanceCriteria` هر Milestone انجام می‌شود.

## یادگیری تطبیقی

Android Host به قابلیت‌های مشترک Core متصل است:

- `basic-qz-placement-001` برای تعیین سطح
- `PlacementResultRepository` برای بازیابی نتیجه
- `PlacementEngine.fourLevelPolicy()` برای پیشنهاد سطح
- `LearningPathEngine.firstLessonIdForLevelType()` برای شروع اولین درس سطح پیشنهادی
- `WeakTopicReviewRepository` برای تبدیل Quiz History به پیشنهاد مرور
- Glossary به‌عنوان منبع واحد Flashcard
- `FlashcardReviewRepository` و Spaced Review با Ratingهای Again/Hard/Good/Easy
- Backup/Restore برنامه مرور و Progress کاربر

## وضعیت Android و QA

- Theme/AppShell/Home/Catalog و Lesson/Quiz/Exercise/Project/Settings/Review از facade مشترک MainUi استفاده می‌کنند.
- Placement Summary، Weak Topic Review و Flashcard Review فعال‌اند و Presentation آن‌ها از MainUi عبور می‌کند.
- Quiz History، Exercise Draft/Completion، Project Progress و Flashcard Progress در Room مشترک ذخیره می‌شوند.
- Course Package از MainCourse دریافت و قبل Build با Validator/Compiler رسمی Core بررسی می‌شود.
- GitHub Actions: `Checkout MainCourse/MainUi/Core -> Validate -> Compile -> MainUi Lint/Build -> Basic Lint/Debug -> Release -> SHA-256 -> QA Artifacts`.
- خط توسعه فعلی `versionCode=10 / versionName=1.1.0-dev` است؛ package و signing identity نسخه 1.0.0 تغییر نکرده‌اند.
- APK Publish نهایی با keystore خصوصی و پایدار خارج از repository عمومی امضا می‌شود.

## Build

چیدمان پیش‌فرض توسعه چهار Repository هم‌سطح است: `AS-Academy-Core/`، `AS-Academy-MainUi/`، `AS-Academy-MainCourse/` و `AS-Academy-Basic/`. اسکریپت prepare-course فقط محتوای canonical MainCourse را Compile می‌کند و عمداً به Snapshot محلی fallback نمی‌کند.

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

### 1.1.0-dev — MainCourse/MainUi architecture migration

- انتقال کامل Course Package دوره Basic به `AS-Academy-MainCourse/courses/basic/course`
- تبدیل MainCourse به Single Source of Truth محتوای Basic
- افزودن `AS-Academy-MainUi` به build واقعی Android
- انتقال Theme، AppShell، Home، Learning Catalog و Screenهای مشترک پشت facade MainUi
- ارتقا runtime به Core 1.3.0 و فعال‌سازی Learning Catalog
- ارتقا Android به `versionCode=10 / versionName=1.1.0-dev` بدون تغییر package/signing identity
- CI یکپارچه `MainCourse -> Core -> MainUi -> Basic`

### 1.0.0 — Stable Release

- تثبیت Curriculum چهارسطحی کامل
- 157 درس، 73 Quiz، 534 سؤال، 195 Exercise و 14 Project
- Placement، Weak Topic Review و Spaced Review end-to-end
- Final Capstone و Interview Bank کامل
- Release QA برای Debug و Release variant و SHA-256
- Android `versionCode` به 9 افزایش یافت

### 0.2.6 — Micro Quiz checkpoints

- 20 Micro Quiz پنج‌سؤالی؛ پنج مورد برای هر سطح
- افزایش Quiz Bank از 53 به 73
- افزایش Question Bank از 434 به 534 سؤال
- اتصال Micro Quizها به چهار درس جمع‌بندی
- Tagهای موضوعی برای Weak Topic Review
- افزایش Android versionCode به 8

### 0.2.5 — Interview Bank

- 5 Interview Assessment با 100 سؤال
- افزایش Question Bank به 434 سؤال

### 0.2.4 — Multi-topic Challenge Bank

- 40 Challenge Exercise و افزایش Exercise Bank به 195 تمرین

### 0.2.3 — Adaptive Android integration

- Placement، Weak Topic Review و Flashcard/Spaced Review end-to-end

### 0.2.2 — Assessment depth expansion

- 4 Depth Assessment و 80 سؤال سناریویی

### 0.2.1 — Learning quality foundation

- Placement Test، Glossary expansion و Project Rubric

### 0.2.0 — Four-level curriculum

- تکمیل مسیر چهارسطحی، 157 درس، 14 پروژه و Final Capstone

## وضعیت فعلی

`1.0.0 released / 1.1.0-dev architecture migration active / content source = MainCourse / presentation = MainUi / runtime = Core 1.3.0`
