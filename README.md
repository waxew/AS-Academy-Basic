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
- نسخه فعلی Host/Course: `0.1.0`

## قانون معماری

این Repository فقط بخش‌های اختصاصی Basic را نگه می‌دارد:

- Course Package و محتوای آموزشی Basic
- سرفصل‌ها، درس‌ها، مثال‌ها، تمرین‌ها، Quizها، آزمون‌ها و پروژه‌ها
- Branding و Assetهای Basic
- Android Host و تنظیمات اختصاصی برنامه

قابلیت‌های عمومی مانند Navigation، Drawer/Profile، Settings، Room Database، Progress، Search، Bookmark، Notes، Quiz Engine/UI، Exercise workflow، Project workflow، Achievement، Backup/Restore، Content Update و Lesson Renderer در `AS-Academy-Core` قرار دارند و در این Repository دوباره نوشته نمی‌شوند.

## مدل آموزشی

چرخه استاندارد هر موضوع:

`Learn -> Example -> Practice -> Quiz -> Challenge -> Project -> Exam -> Review`

هر درس می‌تواند شامل هدف، پیش‌نیاز، توضیح ساده و تخصصی، مثال، نکته، خطای رایج، تمرین چندسطحی، Hint، پاسخ تشریحی، Quiz، پروژه، مرور، واژه‌نامه و سؤال مصاحبه باشد.

## چهار سطح اصلی

### 1. مبانی

سواد رایانه و سیستم‌عامل، رشته‌ها و بازار کار، منطق و حل مسئله، الگوریتم، فلوچارت، شبه‌کد، متغیر و نوع داده، عملگر، ورودی/خروجی، شرط، حلقه و تابع.

### 2. مقدماتی

آرایه و مجموعه، رشته، تاریخ و زمان، مدیریت خطا، فایل، JSON/CSV/XML، ترمینال، Git/GitHub، Branch/Merge/Pull Request، Debugging، Testing مقدماتی و مستندسازی.

### 3. پیشرفته

OOP، Functional Programming، Recursion، Data Structures، Search/Sort، Big-O، مدیریت حافظه، Testing پیشرفته، Clean Code، Refactoring، SOLID و Design Patterns.

### 4. تخصصی و بازار کار

Software Architecture، Dependency Management، Versioning، Security، Code Review، Agile/Scrum/Kanban، CI/CD، Open Source، Portfolio، GitHub، Resume و Technical Interview.

## وضعیت محتوای واقعی

در شاخه توسعه جاری:

- **4 سطح اصلی** تعریف شده
- **39 فصل** با Stable ID و ترتیب مشخص تعریف شده
- **89 درس واقعی** نوشته شده
- **24 Quiz** با مجموع **126 سؤال** ثبت شده
- **87 Exercise** با Hint، Solution و Explanation ثبت شده
- **6 پروژه عملی** چندمرحله‌ای ثبت شده
- **39 مدخل Glossary** فعلی ثبت شده
- هر **10 فصل سطح مبانی** دارای محتوای آموزشی واقعی است
- هر **12 فصل سطح مقدماتی** دارای محتوای آموزشی واقعی است
- آزمون جامع و پروژه پایان سطح برای مبانی ایجاد شده
- آزمون جامع و پروژه پایان سطح برای مقدماتی ایجاد شده
- Android Host مستقل Basic فعال است
- Quiz/Exercise/Project از Screenهای عمومی Core استفاده می‌کنند
- Quiz History، Exercise Draft/Completion و Project Progress در Room مشترک ذخیره می‌شوند
- CI قبل از Build، Course Package را Validate و Compile می‌کند
- Build واقعی Basic روی main با Validate → Compile → Lint → Assemble Debug → Upload Artifact موفق شده است

این اعداد محتوای واقعی‌اند، نه Placeholder. مبانی و مقدماتی پوشش اولیه end-to-end دارند و enrichment آن‌ها در فازهای بعدی ادامه می‌یابد.

## پروژه‌های مرحله‌ای فعلی

- `basic-prj-001` — پروژه شروع مسیر
- `basic-prj-002` — پروژه تحلیل داده‌های پایه
- `basic-prj-003` — پروژه پایان مبانی: سامانه مدیریت هزینه روزانه
- `basic-prj-004` — تحلیل‌گر فعالیت و زمان
- `basic-prj-005` — Import/Export آفلاین امن
- `basic-prj-006` — پروژه پایان مقدماتی: ابزار Import و Report مهندسی‌شده

## هدف محتوایی نسخه جامع

حداقل هدف فعلی ـ و نه سقف پروژه ـ عبارت است از:

- بیش از 100 درس عمیق
- صدها مثال واقعی و سناریوی حل مسئله
- بیش از 300 تمرین مرحله‌ای
- Question Bank بزرگ برای Lesson/Chapter/Level Exam
- Placement Test و Weak Topic Review
- Flashcard و Spaced Review
- پروژه‌های پایان سطح و Final Capstone
- بانک سؤال مصاحبه و تمرین حل مسئله
- مسیر آمادگی Portfolio و ورود به بازار کار

یک درس فقط زمانی Done است که آموزش واقعی، مثال، تمرین، ارزیابی و ارتباط صحیح با پیش‌نیازها داشته باشد و Validator هسته بدون خطا اجرا شود.

## ساختار Repository

```text
AS-Academy-Basic/
├── .github/workflows/      # Quality Gate و ساخت APK Debug
├── app/                    # Android Host اختصاصی Basic
├── course/basic/           # Course Package قابل ویرایش
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

برای توسعه محلی دو Repository را کنار هم قرار دهید:

```text
workspace/
├── AS-Academy-Core/
└── AS-Academy-Basic/
```

Basic از Composite Build استفاده می‌کند و Runtime مشترک را از `AS-Academy-Core` مصرف می‌کند.

## آماده‌سازی Course Bundle

Linux/macOS:

```bash
./scripts/prepare-course.sh
```

Windows:

```bat
scripts\prepare-course.bat
```

خروجی در `app/src/main/assets/basic-course.json` ساخته می‌شود و عمداً داخل Git Commit نمی‌شود.

## Build اندروید

Linux/macOS:

```bash
../AS-Academy-Core/gradlew -p . :app:assembleDebug
```

Windows:

```bat
..\AS-Academy-Core\gradlew.bat -p . :app:assembleDebug
```

GitHub Actions مراحل Validate → Compile Course Bundle → Lint → Assemble Debug → Upload APK Artifact را اجرا می‌کند.

## Version History

### 0.1.0 — Foundation + Fundamentals + Beginner

- ایجاد رسمی پروژه Basic و اتصال به AS-Academy-Core
- تعریف چهار سطح و 39 فصل اصلی
- ایجاد Android Host Compose و workflowهای مشترک Quiz/Exercise/Project
- اتصال Room برای تاریخچه آزمون، Draft و Progress فعالیت‌ها
- ایجاد Script تولید Course Bundle و CI
- تکمیل پوشش اولیه سطح مبانی با 41 درس
- تکمیل پوشش اولیه سطح مقدماتی با 48 درس
- ایجاد آزمون‌ها، تمرین‌ها و پروژه‌های مرحله‌ای و پایان سطح
- تأیید Build واقعی Android و Course Package در GitHub Actions

## وضعیت فعلی

پروژه در فاز **Fundamentals covered / Beginner covered / Advanced next** قرار دارد. مرحله بعدی: OOP، Functional Programming، Recursion، Data Structures، Search/Sort، Big-O، Memory، Testing پیشرفته، Clean Code/Refactoring، SOLID و Design Patterns.
