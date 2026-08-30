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
- Core: `AS-Academy-Core >= 1.0.1`
- نسخه Host/Course: **0.2.1**
- Android `versionCode`: **3**

## قانون معماری

این Repository فقط بخش‌های اختصاصی Basic را نگه می‌دارد: Course Package، محتوای آموزشی، Branding و Android Host اختصاصی. Navigation، Drawer/Profile، Settings، Room Database، Progress، Search، Bookmark، Notes، Quiz/Exercise/Project Engine و UI، Achievement، Backup/Restore، Content Update، Lesson Renderer و منطق مرور مشترک در `AS-Academy-Core` قرار دارند و در Basic تکرار نمی‌شوند.

## مدل آموزشی

چرخه استاندارد:

`Placement -> Learn -> Example -> Practice -> Quiz -> Weak Topic Review -> Challenge -> Project -> Exam -> Spaced Review`

درس‌ها بر حسب موضوع شامل هدف و پیش‌نیاز، توضیح شهودی و تخصصی، مثال، نکته و خطای رایج، تمرین، Hint/Solution، Quiz، پروژه، مرور، واژه‌نامه و سؤال مصاحبه هستند.

## چهار سطح اصلی

1. **مبانی** — سواد رایانه، مسیرهای شغلی، حل مسئله، الگوریتم، داده، I/O، شرط، حلقه و تابع.
2. **مقدماتی** — Collection، String، Date/Time، Error/File/Data Format، CLI، Git، Debugging، Testing و Documentation.
3. **پیشرفته** — OOP، Functional، Recursion، Data Structures، Search/Sort، Complexity، Memory، Advanced Testing، Clean Code/Refactoring، SOLID و Design Patterns.
4. **تخصصی و بازار کار** — Architecture، Dependency/Versioning، Security، Teamwork/Agile/Review، CI/CD/Open Source، Portfolio/Resume و Technical Interview.

## وضعیت محتوای واقعی نسخه 0.2.1

- **4 سطح اصلی**
- **39 فصل** با Stable ID
- **157 درس واقعی**
- **44 Quiz** با مجموع **254 سؤال**
- **155 Exercise** دارای Hint، Solution و Explanation
- **14 Project** چندمرحله‌ای
- **69 Glossary entry** برای واژه‌نامه و Flashcard seed
- **1 Placement Test جامع 32 سؤالی**
- مبانی: **41 درس / 10 فصل**
- مقدماتی: **48 درس / 12 فصل**
- پیشرفته: **44 درس / 11 فصل**
- تخصصی و بازار کار: **24 درس / 6 فصل**

همه چهار سطح مسیر آموزشی end-to-end، ارزیابی و پروژه دارند. اعداد بالا Placeholder نیستند و هر آیتم محتوای واقعی دارد.

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

## کیفیت یادگیری

نسخه 0.2.1 پایه یادگیری تطبیقی را اضافه می‌کند:

- `basic-qz-placement-001` برای تعیین نقطه شروع
- استفاده از Question Tagها و `weakTags` برای مرور هدفمند
- Glossary گسترده‌تر به‌عنوان منبع واحد Flashcardها
- استاندارد Spaced Review بدون duplication محتوای Course
- Rubric استاندارد پروژه‌ها
- Definition of Learning Done به‌جای Complete شدن صرفاً با بازکردن درس

جزئیات در `docs/LEARNING_QUALITY.md` مستند شده است.

## وضعیت فنی Android

- Android Host مستقل Basic فعال است.
- Lesson/Quiz/Exercise/Project به UI مشترک Core وصل‌اند.
- Quiz History، Exercise Draft/Completion و Project Progress در Room مشترک ذخیره می‌شوند.
- Course Package قبل Build با Validator/Compiler رسمی Core بررسی می‌شود.
- Core `1.0.1` سازگاری `EXERCISE_LINK` و dependency عمومی Room را برای Course Hostها فراهم می‌کند.
- GitHub Actions مسیر `Validate -> Compile -> Lint -> Assemble Debug -> Upload APK Artifact` را اجرا می‌کند.
- نسخه Android به `versionCode=3 / versionName=0.2.1` افزایش یافته تا نصب روی نسخه قبلی update-friendly باقی بماند.

## Enrichment بعد از پوشش سرفصل اصلی

انجام‌شده در فاز فعلی:

- Placement Test
- Question Bank اولیه گسترده‌تر
- Weak Topic Review contract/flow
- Flashcard و Spaced Review foundation
- Rubric پروژه‌ها
- Glossary گسترده‌تر

ادامه توسعه محتوایی:

- Micro Quiz و Lesson Exam بیشتر
- Challenge Exerciseهای بیشتر
- Diagram و Assetهای بصری
- بانک سؤال مصاحبه بزرگ‌تر
- Question Bank چندصدسؤالی عمیق‌تر برای هر Level
- UI کامل Review Session و Placement Summary

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

`Four-level curriculum covered / Learning-quality phase in validation / Release hardening next`
