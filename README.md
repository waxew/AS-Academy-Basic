# AS Academy Basic

`Basic` دورهٔ پایه و پیش‌نیاز مشترک برنامه‌نویسی در مجموعهٔ AS Academy است. این برنامه قبل از دوره‌های زبان‌محور مانند Python، Java، Kotlin، C، C++، C#، JavaScript و PHP قرار می‌گیرد و مفاهیم مشترک برنامه‌نویسی و مهندسی نرم‌افزار را از صفر تا آمادگی ورود به مسیر تخصصی آموزش می‌دهد.

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

چرخهٔ استاندارد هر موضوع:

`Learn -> Example -> Practice -> Quiz -> Challenge -> Project -> Exam -> Review`

هر درس در توسعهٔ کامل می‌تواند شامل این لایه‌ها باشد:

- هدف یادگیری و پیش‌نیاز
- توضیح ساده و شهودی
- تعریف دقیق و واژگان تخصصی
- مثال ساده و مثال واقعی
- نکات مهم و اشتباهات رایج
- تمرین Easy / Medium / Challenge
- Hint مرحله‌ای و پاسخ تشریحی
- Micro Quiz و Lesson Exam
- Chapter Exam و Level Exam
- پروژهٔ کوچک یا Practical Assessment
- خلاصه، مرور و فلش‌کارت
- واژه‌نامهٔ فارسی/انگلیسی
- سؤال مصاحبه در مباحث مناسب
- ثبت نقاط ضعف برای مرور بعدی

## چهار سطح اصلی

### 1. مبانی

سواد رایانه و سیستم‌عامل، رشته‌ها و بازار کار، منطق و حل مسئله، الگوریتم، فلوچارت، شبه‌کد، متغیر و نوع داده، عملگر، ورودی/خروجی، شرط، حلقه و تابع.

### 2. مقدماتی

آرایه و مجموعه، رشته، تاریخ و زمان، مدیریت خطا، فایل، JSON/CSV/XML، ترمینال، Git/GitHub، Branch/Merge/Pull Request، Debugging، Testing مقدماتی و مستندسازی.

### 3. پیشرفته

OOP، Functional Programming، Recursion، Data Structures، Search/Sort، Big-O، مدیریت حافظه، Testing پیشرفته، Clean Code، Refactoring، SOLID و Design Patterns.

### 4. تخصصی و بازار کار

Software Architecture، Dependency Management، Versioning، Security، Code Review، Agile/Scrum/Kanban، CI/CD، Open Source، Portfolio، GitHub، Resume و Technical Interview.

## وضعیت محتوای ثبت‌شده در نسخه 0.1.0

- **4 سطح اصلی** تعریف شده
- **39 فصل** با Stable ID و ترتیب مشخص تعریف شده
- **6 درس واقعی** اولیه نوشته شده
- **3 Quiz** با مجموع 12 سؤال ثبت شده
- **5 تمرین** با Hint، Solution و Explanation ثبت شده
- **1 پروژه عملی** چندمرحله‌ای ثبت شده
- **6 مدخل Glossary** اولیه ثبت شده
- Android Host مستقل Basic ایجاد شده
- Quiz/Exercise/Project به Screenهای عمومی Core متصل شده‌اند
- Quiz History، Exercise Draft/Completion و Project Progress در Room مشترک ذخیره می‌شوند
- CI قبل از Build، Course Package را Validate و Compile می‌کند

تعداد فعلی محتوا فقط نقطه شروع است و به‌عنوان تکمیل دوره در نظر گرفته نمی‌شود.

## هدف محتوایی نسخه جامع

حداقل هدف فعلی ـ و نه سقف پروژه ـ عبارت است از:

- بیش از 100 درس عمیق
- صدها مثال واقعی و سناریوی حل مسئله
- بیش از 300 تمرین مرحله‌ای
- حدود 1000 سؤال Quiz/Exam و در صورت نیاز بیشتر
- آزمون‌های پایان درس، فصل و سطح
- Placement Test برای تعیین سطح
- سیستم Weak Topics و مرور هوشمند
- Flashcard و مرور فاصله‌دار
- پروژه‌های کوچک در طول دوره
- پروژه‌های پایان سطح
- Final Capstone چندمرحله‌ای
- بانک سؤال مصاحبه و تمرین حل مسئله
- مسیر آمادگی Portfolio و ورود به بازار کار

عدد محتوا معیار اصلی کیفیت نیست. یک درس فقط زمانی Done است که آموزش واقعی، مثال، تمرین، ارزیابی و ارتباط صحیح با پیش‌نیازها داشته باشد و Validator هسته بدون خطا اجرا شود.

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
├── docs/                   # Curriculum، استاندارد محتوا و Roadmap
├── scripts/                # Validate/Compile Course Package
├── build.gradle.kts
├── settings.gradle.kts
└── README.md
```

## اتصال به AS Academy Core

برای توسعهٔ محلی دو Repository را کنار هم قرار دهید:

```text
workspace/
├── AS-Academy-Core/
└── AS-Academy-Basic/
```

Basic از Composite Build استفاده می‌کند و مختصات Runtime مشترک را به `com.asdevelopers.academy:core:1.0.0` متصل می‌کند.

## آماده‌سازی Course Bundle

قبل از اجرای Android Host باید فایل‌های قابل ویرایش `course/basic` با ابزار رسمی Core Validate و Compile شوند.

Linux/macOS:

```bash
./scripts/prepare-course.sh
```

Windows:

```bat
scripts\prepare-course.bat
```

خروجی در مسیر زیر ساخته می‌شود و عمداً داخل Git Commit نمی‌شود:

```text
app/src/main/assets/basic-course.json
```

## Build اندروید

بعد از اجرای `prepare-course` می‌توان از Gradle Wrapper موجود در Core برای Build استفاده کرد:

Linux/macOS:

```bash
../AS-Academy-Core/gradlew -p . :app:assembleDebug
```

Windows:

```bat
..\AS-Academy-Core\gradlew.bat -p . :app:assembleDebug
```

GitHub Actions همین مراحل را به‌صورت خودکار اجرا می‌کند: Validate → Compile Course Bundle → Lint → Assemble Debug → Upload APK Artifact.

## Version History

### 0.1.0 — Foundation

- ایجاد رسمی پروژه Basic
- تعریف Course ID و Android package پایدار
- اتصال معماری به AS-Academy-Core
- تعریف چهار سطح و 39 فصل اصلی
- ایجاد استاندارد تولید محتوای آموزشی
- نوشتن اولین شش درس واقعی
- افزودن Quiz، Exercise، Glossary و پروژه عملی اولیه
- ایجاد Android Host Compose
- اتصال Lesson به Quiz/Exercise/Project workflow مشترک
- اتصال Room برای تاریخچه آزمون، Draft و Progress فعالیت‌ها
- ایجاد Script تولید Course Bundle
- ایجاد CI برای Validation و Build خودکار

## وضعیت فعلی

پروژه در فاز **Foundation complete / Fundamentals content in progress** قرار دارد. قدم محتوایی بعدی گسترش سطح مبانی از درس 7 به بعد و تبدیل فصل‌های Algorithm، Variables، Operators، I/O، Conditions، Loops و Functions به بسته‌های کامل آموزشی است.
