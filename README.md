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
- Core: `AS-Academy-Core >= 1.2.0`
- نسخه Host/Course: **0.2.5**
- Android `versionCode`: **7**

## قانون معماری

این Repository فقط بخش‌های اختصاصی Basic را نگه می‌دارد: Course Package، محتوای آموزشی، Branding و Android Host اختصاصی. Navigation، Drawer/Profile، Settings، Room Database، Progress، Search، Bookmark، Notes، Quiz/Exercise/Project Engine و UI، Achievement، Backup/Restore، Content Update، Lesson Renderer، Placement، Weak Topic Review و Spaced Review در `AS-Academy-Core` قرار دارند و در Basic تکرار نمی‌شوند.

## مدل آموزشی

چرخه استاندارد:

`Placement -> Learn -> Example -> Practice -> Quiz -> Weak Topic Review -> Challenge -> Project -> Exam -> Spaced Review -> Interview Defense`

درس‌ها بر حسب موضوع شامل هدف و پیش‌نیاز، توضیح شهودی و تخصصی، مثال، نکته و خطای رایج، تمرین، Hint/Solution، Quiz، پروژه، مرور، واژه‌نامه و سؤال مصاحبه هستند.

## چهار سطح اصلی

1. **مبانی** — سواد رایانه، مسیرهای شغلی، حل مسئله، الگوریتم، داده، I/O، شرط، حلقه و تابع.
2. **مقدماتی** — Collection، String، Date/Time، Error/File/Data Format، CLI، Git، Debugging، Testing و Documentation.
3. **پیشرفته** — OOP، Functional، Recursion، Data Structures، Search/Sort، Complexity، Memory، Advanced Testing، Clean Code/Refactoring، SOLID و Design Patterns.
4. **تخصصی و بازار کار** — Architecture، Dependency/Versioning، Security، Teamwork/Agile/Review، CI/CD/Open Source، Portfolio/Resume و Technical Interview.

## وضعیت محتوای واقعی نسخه 0.2.5

- **4 سطح اصلی**
- **39 فصل** با Stable ID
- **157 درس واقعی**
- **53 Quiz** با مجموع **434 سؤال**
- **195 Exercise** دارای Hint، Solution و Explanation
- **40 Challenge Exercise چندموضوعی**؛ 10 مورد برای هر سطح
- **100 سؤال Interview Bank** در 5 آزمون تخصصی
- **14 Project** چندمرحله‌ای
- **69 Glossary entry** برای واژه‌نامه و Flashcard seed
- **1 Placement Test جامع 32 سؤالی**
- **4 Depth Assessment سطحی با مجموع 80 سؤال**
- مبانی: **41 درس / 10 فصل**
- مقدماتی: **48 درس / 12 فصل**
- پیشرفته: **44 درس / 11 فصل**
- تخصصی و بازار کار: **24 درس / 6 فصل**

همه چهار سطح مسیر آموزشی end-to-end، ارزیابی، Challenge، پروژه و آمادگی مصاحبه دارند. اعداد بالا Placeholder نیستند و هر آیتم محتوای واقعی دارد.

## Interview Bank نسخه 0.2.5

صد سؤال جدید به‌صورت پنج آزمون 20 سؤالی طراحی شده‌اند. سؤال‌ها فقط حفظ اصطلاح نیستند و explanation و Tag موضوعی دارند تا برای Weak Topic Review نیز قابل استفاده باشند.

- `basic-qz-interview-001` — **حل مسئله و الگوریتم**: constraints، Big-O، search، recursion، stack/queue، graph، heap، sliding window و reasoning مصاحبه.
- `basic-qz-interview-002` — **طراحی کد، OOP و Data Structure**: Encapsulation، Composition، SOLID، Functional، Pattern، Hash/Queue/List/Heap، Coupling/Cohesion و Refactoring.
- `basic-qz-interview-003` — **Debugging، Testing و Git**: Root Cause، Stack Trace، Regression، Test Doubles، Coverage، Commit، Merge/Rebase، PR و Code Review.
- `basic-qz-interview-004` — **Architecture، Security و Delivery**: ADR، SemVer، Dependency، Threat Model، AuthN/AuthZ، Least Privilege، CI/CD، Migration، Incident و Open Source.
- `basic-qz-interview-005` — **System Design، Behavioral و Career**: NFR، Offline-First، Sync، Idempotency، Cache، Replication/Sharding، Observability، STAR، Portfolio و Mock Interview.

هر پنج آزمون از درس نهایی `basic-spc-024` قابل بازشدن‌اند و نتیجه آن‌ها وارد تاریخچه Quiz و Weak Topic Review مشترک Core می‌شود.

## بانک Challenge نسخه 0.2.4+

Challengeها زبان‌خنثی و چندموضوعی هستند تا قبل از ورود به دوره‌های زبان‌محور، توان حل مسئله و مهندسی کاربر را بسنجند. از `BUILD_FEATURE` و `READ_AND_ANSWER` در Exercise Engine مشترک استفاده شده و منطق Runner زبان خاصی داخل Basic اضافه نشده است.

- `basic-ex-156` تا `basic-ex-165` — **مبانی**: validation pipeline، rule precedence، statistics، menu state، transaction stream، ATM، password policy، inventory و گزارش مالی.
- `basic-ex-166` تا `basic-ex-175` — **مقدماتی**: CSV/JSON، migration، timezone، file recovery، CLI، Git conflict، debugging، test matrix، API contract و Backup/Restore.
- `basic-ex-176` تا `basic-ex-185` — **پیشرفته**: OOP/Composition، Functional Core، Recursion/Tree، Graph، Hash Index، Search/Sort، Big-O optimization، Memory audit، Test Architecture و Refactoring/SOLID/Patterns.
- `basic-ex-186` تا `basic-ex-195` — **تخصصی**: ADR، Dependency Policy، Threat Model، AuthN/AuthZ، Code Review، Incident Delivery، CI/CD، Open Source، Portfolio و Mock System Design.

همه Challengeها Hint، Solution، Explanation و Tagهای موضوعی دارند و از درس جمع‌بندی سطح مربوط قابل بازشدن‌اند.

## بانک سنجش عمیق

چهار آزمون عمیق تمرکزشان روی reasoning، boundary، trade-off و سناریوهای واقعی است:

- `basic-qz-depth-fundamentals-001` — Problem Solving، Algorithm، Validation، Control Flow و Function Design
- `basic-qz-depth-beginner-001` — Collections، Date/Time، Error/File/Data Format، CLI، Git، Debugging، Testing و Documentation
- `basic-qz-depth-advanced-001` — OOP/Functional، Recursion، Data Structures، Complexity، Memory، Testing، Refactoring، SOLID و Patterns
- `basic-qz-depth-specialist-001` — Architecture، Versioning، Security، Team Delivery، CI/CD، Open Source، Portfolio و Interview

Question Tagها برای اتصال به `weakTags` و Weak Topic Review حفظ شده‌اند.

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

ارزیابی پروژه‌ها طبق Rubric صد امتیازی `docs/PROJECT_RUBRIC.md` انجام می‌شود و `acceptanceCriteria` هر Milestone معیار اجرایی همان مرحله است.

## کیفیت یادگیری تطبیقی

قابلیت‌های مشترک Core 1.2.0 به Android Host واقعی Basic متصل‌اند:

- `basic-qz-placement-001` آزمون تعیین سطح واقعی است و Attempt آن در Room ذخیره می‌شود.
- `PlacementResultRepository` آخرین نتیجه را پس از Rotation/Restart بازیابی می‌کند.
- `PlacementEngine.fourLevelPolicy()` نمره را به سطح پیشنهادی تبدیل می‌کند.
- `LearningPathEngine.firstLessonIdForLevelType()` کاربر را به اولین درس واقعی سطح پیشنهادی می‌برد.
- `WeakTopicReviewRepository` تاریخچه `weakTags` را به درس‌های اولویت‌دار برای مرور تبدیل می‌کند.
- Glossary منبع واحد Flashcard است و محتوا برای کارت‌ها Duplicate نمی‌شود.
- `FlashcardReviewRepository` زمان‌بندی Spaced Review و Progress کارت‌ها را در Room نگه می‌دارد.
- Ratingهای Again / Hard / Good / Easy از UI مشترک Core ثبت می‌شوند.
- Progress مرور در Backup/Restore مشترک Core حفظ می‌شود.
- Rubric استاندارد پروژه‌ها و Definition of Learning Done تکمیل‌شدن واقعی مهارت را معیار قرار می‌دهند.

جزئیات محتوایی در `docs/LEARNING_QUALITY.md` مستند شده است.

## وضعیت فنی Android

- Android Host مستقل Basic فعال است.
- Lesson/Quiz/Exercise/Project به UI مشترک Core وصل‌اند.
- Placement Summary، Weak Topic Review و Flashcard Review نیز به Route و Screenهای مشترک Core وصل‌اند.
- Quiz History، Exercise Draft/Completion، Project Progress و Flashcard Progress در Room مشترک ذخیره می‌شوند.
- Course Package قبل Build با Validator/Compiler رسمی Core بررسی می‌شود.
- Core `1.2.0` منبع رسمی Navigation، Adaptive Review، Placement، Spaced Review، Persistence و UI مشترک است.
- GitHub Actions مسیر `Validate -> Compile -> Lint -> Assemble Debug -> Upload APK Artifact` را اجرا می‌کند.
- نسخه Android به `versionCode=7 / versionName=0.2.5` افزایش یافته تا نصب روی نسخه قبلی update-friendly باقی بماند.

## Enrichment بعد از پوشش سرفصل اصلی

انجام‌شده:

- Placement Test
- Question Bank تا 434 سؤال
- چهار Depth Assessment سطحی
- Interview Bank صدسؤالی
- Weak Topic Review end-to-end
- Flashcard و Spaced Review end-to-end
- Placement Summary و شروع سطح پیشنهادی
- Persistence و Backup/Restore مرور از Core
- 40 Challenge Exercise چندموضوعی
- Rubric پروژه‌ها
- Glossary گسترده‌تر

ادامه توسعه محتوایی:

- Micro Quiz و Lesson Exam بیشتر برای درس‌های پرریسک
- Diagram و Assetهای بصری
- افزایش Exercise Bank به سمت 300–500 تمرین
- افزایش Question Bank به سمت حدود 1000 سؤال
- Scenario Lab و Mock Interviewهای تعاملی بیشتر

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
│   ├── assets.json
│   └── references.json
├── docs/
│   ├── LEARNING_QUALITY.md
│   └── PROJECT_RUBRIC.md
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

Basic از Runtime و Contract مشترک `AS-Academy-Core` استفاده می‌کند.

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

### 0.2.5 — 100-question Interview Bank

- اضافه‌شدن 5 آزمون Interview با مجموع 100 سؤال واقعی
- افزایش Quiz Bank از 48 به 53 آزمون
- افزایش Question Bank از 334 به 434 سؤال
- پوشش Problem Solving، Code Design، Debug/Test/Git، Architecture/Security/Delivery و System Design/Behavioral
- اتصال پنج آزمون به درس نهایی و History/Weak Topic Review مشترک
- افزایش Android versionCode به 7 برای Update سالم

### 0.2.4 — Multi-topic Challenge Bank

- اضافه‌شدن 40 Challenge Exercise واقعی و چندموضوعی
- 10 Challenge برای هر یک از چهار سطح
- افزایش Exercise Bank از 155 به 195 تمرین
- پوشش سناریوهای validation، data import، algorithms، architecture، security، CI/CD و interview defense
- حفظ language-neutral بودن Basic با `BUILD_FEATURE` و `READ_AND_ANSWER`
- افزایش Android versionCode به 6 برای Update سالم

### 0.2.3 — Adaptive Android integration

- اتصال آزمون تعیین سطح واقعی به Android Host
- Persist نتیجه Placement و نمایش Summary مشترک Core
- شروع مستقیم اولین درس سطح پیشنهادی
- اتصال Weak Topic Review به تاریخچه واقعی Quiz
- اتصال Flashcard/Spaced Review به Glossary و Room
- استفاده کامل از Core 1.2.0 بدون تکرار منطق Adaptive Learning در Basic
- افزایش Android versionCode به 5 برای Update سالم

### 0.2.2 — Assessment depth expansion

- اضافه‌شدن 4 آزمون عمیق مستقل برای چهار سطح
- اضافه‌شدن 80 سؤال سناریویی و reasoning-based
- افزایش بانک سؤال از 254 به 334 سؤال
- حفظ Tagهای موضوعی برای Weak Topic Review
- افزایش Android versionCode به 4 برای Update سالم

### 0.2.1 — Learning quality foundation

- آزمون تعیین سطح جامع 32 سؤالی با وزن و Tag موضوعی
- افزایش بانک سؤال به 254 سؤال
- افزایش Glossary به 69 مدخل و آماده‌سازی Flashcard seed
- تعریف Weak Topic Review و Spaced Review workflow
- اضافه‌شدن Rubric صد امتیازی پروژه‌ها
- افزایش Android versionCode به 3 برای Update سالم

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

`Four-level curriculum covered / Adaptive learning integrated / 195 exercises / 434 questions / Interview Bank in validation`
