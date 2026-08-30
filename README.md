# AS Academy Basic

`Basic` دوره پایه و پیش‌نیاز مشترک برنامه‌نویسی در مجموعه AS Academy است. این برنامه قبل از دوره‌های زبان‌محور مانند Python، Java، Kotlin، C، C++، C#، JavaScript و PHP قرار می‌گیرد و مفاهیم مشترک برنامه‌نویسی و مهندسی نرم‌افزار را از صفر تا آمادگی ورود به مسیر تخصصی آموزش می‌دهد.

## هویت پروژه

- نام برنامه: **Basic**
- Repository: `AS-Academy-Basic`
- Course ID: `basic`
- Android package: `com.asdevelopers.academy.basic`
- زبان اصلی محتوا: فارسی و RTL
- Android: `minSdk 23` / `targetSdk 36`
- Java compatibility: JDK 17
- Core: `AS-Academy-Core >= 1.0.0`
- نسخه توسعه فعلی Host/Course: `0.1.0`

## قانون معماری

این Repository فقط بخش‌های اختصاصی Basic را نگه می‌دارد: Course Package، محتوای آموزشی، Branding و Android Host اختصاصی. Navigation، Drawer/Profile، Settings، Room Database، Progress، Search، Bookmark، Notes، Quiz/Exercise/Project Engine و UI، Achievement، Backup/Restore، Content Update و Lesson Renderer در `AS-Academy-Core` قرار دارند و در Basic تکرار نمی‌شوند.

## مدل آموزشی

چرخه استاندارد:

`Learn -> Example -> Practice -> Quiz -> Challenge -> Project -> Exam -> Review`

یک درس می‌تواند هدف و پیش‌نیاز، توضیح شهودی و تخصصی، مثال، نکته و خطای رایج، تمرین چندسطحی، Hint/Solution، Quiz، پروژه، مرور، واژه‌نامه و سؤال مصاحبه داشته باشد.

## چهار سطح اصلی

1. **مبانی** — سواد رایانه، مسیرهای شغلی، حل مسئله، الگوریتم، داده، I/O، شرط، حلقه و تابع.
2. **مقدماتی** — Collection، String، Date/Time، Error/File/Data Format، CLI، Git، Debugging، Testing و Documentation.
3. **پیشرفته** — OOP، Functional، Recursion، Data Structures، Search/Sort، Complexity، Memory، Advanced Testing، Clean Code/Refactoring، SOLID و Design Patterns.
4. **تخصصی و بازار کار** — Architecture، Dependency/Versioning، Security، Teamwork/Agile/Review، CI/CD/Open Source، Portfolio/Resume و Technical Interview.

## وضعیت محتوای واقعی

در شاخه توسعه Advanced:

- **4 سطح اصلی** تعریف شده
- **39 فصل** با Stable ID تعریف شده
- **133 درس واقعی**
- **36 Quiz** با مجموع **182 سؤال**
- **131 Exercise** دارای Hint، Solution و Explanation
- **10 Project** چندمرحله‌ای
- **39 Glossary entry** فعلی
- سطح مبانی: **41 درس / 10 فصل**
- سطح مقدماتی: **48 درس / 12 فصل**
- سطح پیشرفته: **44 درس / 11 فصل**

سه سطح اول مسیر آموزشی کامل اولیه، آزمون جامع و پروژه پایان سطح دارند. این اعداد Placeholder نیستند و هر آیتم محتوای واقعی دارد.

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

## وضعیت فنی Android

- Android Host مستقل Basic فعال است.
- Lesson/Quiz/Exercise/Project به UI مشترک Core وصل‌اند.
- Quiz History، Exercise Draft/Completion و Project Progress در Room مشترک ذخیره می‌شوند.
- Course Package قبل Build با Validator/Compiler رسمی Core بررسی می‌شود.
- GitHub Actions مسیر `Validate -> Compile -> Lint -> Assemble Debug -> Upload APK Artifact` را اجرا می‌کند.
- Build واقعی Basic و Core پس از اصلاح public Room dependency با موفقیت اجرا شده است.

## هدف نسخه جامع

هدف صرفاً عبور از 100 درس نیست. دوره باید Question Bank بزرگ، Micro Quiz، Lesson/Chapter/Level Exam، Placement Test، Weak Topic Review، Flashcard/Spaced Review، Challengeهای بیشتر، پروژه‌های واقعی، Final Capstone، بانک سؤال مصاحبه و مسیر Portfolio/Resume داشته باشد.

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
├── scripts/
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## اتصال به AS Academy Core

دو Repository باید کنار هم باشند:

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

### 0.1.0 — Foundation + Fundamentals + Beginner + Advanced

- اتصال کامل به AS-Academy-Core و Android Host
- تعریف چهار سطح و 39 فصل
- تکمیل پوشش اولیه مبانی، مقدماتی و پیشرفته
- 133 درس، 131 تمرین، 36 Quiz و 10 پروژه واقعی
- آزمون جامع و Capstone برای هر سه سطح تکمیل‌شده
- GitHub Actions و Android Debug APK build فعال و تأیید شده

## وضعیت فعلی

`Fundamentals covered / Beginner covered / Advanced covered / Specialist next`

مرحله بعد: Architecture، Dependency/Versioning، Security، Teamwork/Agile/Code Review، CI/CD/Open Source، Portfolio/Resume و Technical Interview.
