# AS Academy Basic

`Basic` دوره پایه و پیش‌نیاز مشترک برنامه‌نویسی در مجموعه AS Academy است. این برنامه قبل از دوره‌های زبان‌محور مانند Python، Java، Kotlin، C، C++، C#، JavaScript و PHP قرار می‌گیرد و مفاهیم مشترک برنامه‌نویسی و مهندسی نرم‌افزار را از صفر تا آمادگی ورود به بازار کار آموزش می‌دهد.

## هویت پروژه

- نام برنامه: **Basic**
- Repository: `AS-Academy-Basic`
- Course ID: `basic`
- Android package: `com.asdevelopers.academy.basic`
- زبان اصلی محتوا: فارسی و RTL
- Android: `minSdk 23` / `targetSdk 36`
- Java compatibility: JDK 17
- Core: `AS-Academy-Core >= 1.1.0`
- نسخه Host/Course: **0.3.0**
- Android `versionCode`: **3**
- Curriculum version: **0.2.0**؛ ترتیب سرفصل‌های چهارسطحی در 0.3.0 تغییر نکرده و Enrichment آموزشی اضافه شده است.

## قانون معماری

این Repository فقط بخش‌های اختصاصی Basic را نگه می‌دارد: Course Package، محتوای آموزشی، Branding و Android Host اختصاصی. Navigation، Drawer/Profile، Settings، Room Database، Progress، Search، Bookmark، Notes، Quiz/Exercise/Project Engine و UI، Flashcard/Spaced Review Engine و UI، Achievement، Backup/Restore، Content Update و Lesson Renderer در `AS-Academy-Core` قرار دارند و در Basic تکرار نمی‌شوند.

## مدل آموزشی

چرخه استاندارد:

`Learn -> Example -> Practice -> Quiz -> Challenge -> Project -> Exam -> Review`

درس‌ها بر حسب موضوع شامل هدف و پیش‌نیاز، توضیح شهودی و تخصصی، مثال، نکته و خطای رایج، تمرین، Hint/Solution، Quiz، پروژه، مرور، واژه‌نامه، Flashcard، منبع تکمیلی و سؤال مصاحبه هستند.

## چهار سطح اصلی

1. **مبانی** — سواد رایانه، مسیرهای شغلی، حل مسئله، الگوریتم، داده، I/O، شرط، حلقه و تابع.
2. **مقدماتی** — Collection، String، Date/Time، Error/File/Data Format، CLI، Git، Debugging، Testing و Documentation.
3. **پیشرفته** — OOP، Functional، Recursion، Data Structures، Search/Sort، Complexity، Memory، Advanced Testing، Clean Code/Refactoring، SOLID و Design Patterns.
4. **تخصصی و بازار کار** — Architecture، Dependency/Versioning، Security، Teamwork/Agile/Review، CI/CD/Open Source، Portfolio/Resume و Technical Interview.

## وضعیت محتوای واقعی نسخه 0.3.0

- **4 سطح اصلی**
- **39 فصل** با Stable ID
- **157 درس واقعی**
- **43 Quiz** با مجموع **222 سؤال**
- **155 Exercise** دارای Hint، Solution و Explanation
- **14 Project** چندمرحله‌ای
- **147 Glossary entry** در چهار سطح
- **56 Flashcard** مفهومی با اتصال مستقیم به Lesson IDهای واقعی
- **16 منبع رسمی و مرجع** از Unicode، RFC، W3C، Git/GitHub، OWASP، SemVer، Agile/Scrum و Open Source
- مبانی: **41 درس / 10 فصل**
- مقدماتی: **48 درس / 12 فصل**
- پیشرفته: **44 درس / 11 فصل**
- تخصصی و بازار کار: **24 درس / 6 فصل**

همه چهار سطح مسیر آموزشی end-to-end، ارزیابی و پروژه دارند. اعداد بالا Placeholder نیستند و هر آیتم محتوای واقعی دارد.

## مرور Flashcard و Spaced Review

نسخه 0.3.0 مرور مفهومی را از یک فایل محتوایی ساده به قابلیت واقعی برنامه تبدیل می‌کند:

- چهار Deck مستقل برای Fundamentals، Beginner، Advanced و Specialist
- Stable ID برای حفظ Review History در Updateهای بعدی
- Ratingهای `Again / Hard / Good / Easy`
- زمان‌بندی مرور فاصله‌دار توسط `FlashcardReviewEngine` در Core
- Seed خودکار کارت جدید هنگام Import بدون overwrite کردن سابقه قبلی
- صف کارت‌های موعدرسیده و Session ثابت مرور
- ذخیره `repetitions / intervalDays / easeFactor / dueAt / lastReviewedAt` در Room مشترک Core
- Migration غیرتخریبی Database v3 -> v4
- حفظ Review History در Backup/Restore
- ایندکس Front/Back/Hint/Tag در Search مشترک Core
- صفحه و Deck UI مشترک Core؛ Basic فقط Bundle و Database را متصل می‌کند

## پروژه‌های مرحله‌ای

- `basic-prj-001` — پروژه شروع مسیر
- `basic-prj-002` — تحلیل داده‌های پایه
- `basic-prj-003` — Capstone مبانی: مدیریت هزینه روزانه
- `basic-prj-004` — تحلیل‌گر فعالیت و زمان
- `basic-prj-005` — Import/Export آفلاین امن
- `basic-prj-006` — Capstone مقدماتی: ابزار Import/Report مهندسی‌شده
- `basic-prj-007` — Rule Engine و Tree Processor
- `basic-prj-008` — موتور Search/Ranking و تحلیل Complexity
- `basic-prj-009` — Refactor موتور گزارش Legacy
- `basic-prj-010` — Capstone پیشرفته: سامانه Task/Workflow ماژولار
- `basic-prj-011` — معماری و امنیت سامانه اشتراک فایل
- `basic-prj-012` — شبیه‌سازی Team Delivery و CI/CD
- `basic-prj-013` — بسته Portfolio و Resume مهندسی
- `basic-prj-014` — **Final Capstone: Personal Operations Manager**

## Final Capstone

Final Capstone کل دوره باید این مهارت‌ها را در یک محصول واقعی یکپارچه کند:

- Problem/Scope و Acceptance Criteria
- Data Model، Algorithm و Data Structure
- Architecture و Dependency Direction
- Offline Storage، Migration، Backup/Restore و Import/Export
- Security و Threat Model
- Git / Issue / Branch / Pull Request
- Unit / Property / Integration / E2E / Regression Testing
- CI/CD، Artifact و Release Evidence
- README، Changelog و ADR
- Complexity / Performance / Memory Review
- Code Review و Security Review
- Portfolio Case Study
- Mock Technical Interview Defense

## وضعیت فنی Android

- Android Host مستقل Basic فعال است.
- Lesson/Quiz/Exercise/Project به UI مشترک Core وصل‌اند.
- Flashcard به Navigation، Deck UI، Review Engine و Repository مشترک Core وصل است.
- Quiz History، Exercise Draft/Completion، Project Progress و Flashcard Review State در Room مشترک ذخیره می‌شوند.
- `CoursePackageImporter` بعد از Validation، Legacy claim، Flashcard seed و Search Index را در Transaction مشترک انجام می‌دهد.
- Course Package قبل Build با Validator/Compiler رسمی Core بررسی می‌شود.
- Core `1.1.0` قابلیت Flashcard، Room v4، Backup/Restore مرور و سازگاری legacy `EXERCISE_LINK` را فراهم می‌کند.
- GitHub Actions مسیر `Validate -> Compile -> Lint -> Assemble Debug -> Upload APK Artifact` را اجرا می‌کند.
- نسخه Android به `versionCode=3 / versionName=0.3.0` افزایش یافته؛ `applicationId` ثابت است و Migration دیتابیس از v3 به v4 destructive نیست.

## Enrichment بعد از پوشش سرفصل اصلی

پوشش اصلی کامل شده و توسعه محتوایی از اینجا روی عمق و سنجش یادگیری متمرکز می‌شود:

- Micro Quiz و Lesson Exam بیشتر
- Question Bank گسترده‌تر
- Placement Test
- Weak Topic / Wrong Answer Review
- Challenge Exerciseهای بیشتر
- Rubric پروژه‌ها
- Diagram و Assetهای بصری
- بانک سؤال مصاحبه بزرگ‌تر
- گسترش Flashcardها از Deckهای هسته به پوشش granular در سطح Lesson
- تکمیل منابع تکمیلی برای فصل‌های باقی‌مانده

## ساختار Repository

```text
AS-Academy-Basic/
├── .github/workflows/
├── app/
├── course/basic/
│   ├── manifest.json
│   ├── branding.json
│   ├── levels.json
│   ├── chapters.json
│   ├── lessons/
│   ├── quizzes/
│   ├── exercises/
│   ├── projects/
│   ├── glossary/
│   ├── flashcards/
│   ├── assets.json
│   └── references.json
├── docs/
├── scripts/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## اتصال به AS Academy Core

```text
workspace/
├── AS-Academy-Core/
└── AS-Academy-Basic/
```

Basic از Runtime و Contract مشترک `AS-Academy-Core` استفاده می‌کند. هر تغییر reusable باید ابتدا در Core انجام شود و سپس Course Package فقط داده اختصاصی خود را مصرف کند.

## آماده‌سازی و Build

Linux/macOS:

```bash
./scripts/prepare-course.sh
../AS-Academy-Core/gradlew -p . :app:assembleDebug
```

Windows:

```bat
scripts\prepare-course.bat
..\AS-Academy-Core\gradlew.bat -p . :app:assembleDebug
```

Course Bundle در `app/src/main/assets/basic-course.json` تولید می‌شود و فایل generated داخل Git Commit نمی‌شود.

## Version History

### 0.3.0 — Learning review enrichment

- افزودن 56 Flashcard واقعی در چهار سطح
- گسترش Glossary از 39 به 147 مدخل و اتصال به Lesson IDها
- افزودن 16 منبع رسمی و مرجع
- اتصال Host به `CoursePackageImporter`
- اتصال مقصد مرور Flashcard به Navigation/Drawer
- مصرف `AS-Academy-Core 1.1.0` برای Spaced Review، Room v4، Search و Backup/Restore
- افزایش Android `versionCode` به 3 با `applicationId` ثابت و Migration غیرتخریبی

### 0.2.0 — Four-level curriculum

- تکمیل پوشش اصلی هر چهار سطح
- 157 درس، 155 تمرین، 43 Quiz با 222 سؤال و 14 پروژه
- آزمون جامع هر سطح و آزمون جامع نهایی کل Basic
- Final Capstone صفر تا مهندسی، Release، Portfolio و Interview
- ارتقای Core requirement به 1.0.1
- افزایش Android versionCode به 2 برای Update سالم

### 0.1.0 — Foundation

- ایجاد پروژه، Android Host و اتصال به AS-Academy-Core
- تعریف چهار سطح و 39 فصل
- ایجاد Validator/Compiler/CI integration

## وضعیت فعلی

`Four-level curriculum complete / Flashcard and glossary enrichment implemented / Core 1.1.0 quality gate and Basic 0.3.0 integration validation in progress`
