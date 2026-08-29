# AS Academy Basic

`Basic` دورهٔ پایه و پیش‌نیاز مشترک برنامه‌نویسی در مجموعهٔ AS Academy است. هدف برنامه این است که کاربر قبل از ورود به دوره‌های زبان‌محور مانند Python، Java، Kotlin، C، C++، C#، JavaScript و PHP، مفاهیم مشترک و ضروری برنامه‌نویسی را به‌صورت ساختاریافته، تمرین‌محور و پروژه‌محور یاد بگیرد.

## هویت پروژه

- نام برنامه: **Basic**
- Repository: `AS-Academy-Basic`
- Course ID: `basic`
- Android package: `com.asdevelopers.academy.basic`
- زبان اصلی: فارسی (RTL)
- Core: `AS-Academy-Core >= 1.0.0`

## قانون معماری

این Repository فقط بخش‌های اختصاصی Basic را نگه می‌دارد:

- Course Package و محتوای آموزشی Basic
- سرفصل‌ها، درس‌ها، مثال‌ها، تمرین‌ها، Quizها، آزمون‌ها و پروژه‌ها
- Branding و Assetهای Basic
- Android Host و تنظیمات اختصاصی برنامه

قابلیت‌های عمومی مانند Navigation، Drawer/Profile، Settings، Room Database، Progress، Search، Bookmark، Notes، Quiz Engine، Exercise Engine، Project Progress، Achievement، Backup/Restore، Content Update و Lesson Renderer در `AS-Academy-Core` قرار دارند و در این Repository دوباره نوشته نمی‌شوند.

## مدل آموزشی

چرخهٔ استاندارد هر موضوع:

`Learn -> Example -> Practice -> Quiz -> Challenge -> Project -> Exam -> Review`

هر درس می‌تواند شامل هدف یادگیری، پیش‌نیاز، توضیح ساده، توضیح تخصصی، مثال واقعی، نکات مهم، اشتباهات رایج، تمرین Easy/Medium/Challenge، Hint، پاسخ تشریحی، Quiz، آزمون، پروژهٔ کوچک، خلاصه، فلش‌کارت، واژه‌نامه و سؤال مصاحبه باشد.

## سطوح دوره

1. **مبانی** — سواد رایانه، سیستم‌عامل، بازار کار، منطق، حل مسئله، الگوریتم، فلوچارت، شبه‌کد، متغیر، نوع داده، عملگر، ورودی/خروجی، شرط، حلقه و تابع.
2. **مقدماتی** — آرایه و مجموعه، رشته، تاریخ و زمان، خطا، فایل، JSON/CSV/XML، ترمینال، Git/GitHub، مستندسازی، دیباگ و تست مقدماتی.
3. **پیشرفته** — شی‌گرایی، برنامه‌نویسی تابعی، Recursion، ساختمان داده، جست‌وجو و مرتب‌سازی، Big-O، مدیریت حافظه، تست، Clean Code، SOLID و Refactoring.
4. **تخصصی و آمادگی بازار کار** — Design Pattern، معماری نرم‌افزار، امنیت، Dependency Management، Versioning، Code Review، Agile/Scrum، CI/CD، Open Source، Portfolio، رزومه و مصاحبه.

## هدف محتوایی نسخه جامع

- 4 سطح اصلی
- حدود 30 تا 40 فصل
- حداقل 100 درس عمیق
- صدها مثال آموزشی
- حداقل 300 تمرین
- حدود 1000 سؤال Quiz/Exam در توسعهٔ کامل
- پروژه‌های مرحله‌ای و پروژهٔ جامع نهایی
- آزمون تعیین سطح و مرور نقاط ضعف

این اعداد هدف محتوایی هستند؛ هر مورد فقط زمانی تکمیل‌شده محسوب می‌شود که محتوای واقعی، مثال، تمرین و ارزیابی آن نوشته و توسط Validator هسته تأیید شده باشد.

## ساختار Repository

```text
AS-Academy-Basic/
├── app/                    # Android Host اختصاصی Basic
├── course/basic/           # Course Package واقعی
│   ├── manifest.json
│   ├── branding.json
│   ├── levels.json
│   ├── chapters.json
│   ├── lessons/
│   ├── quizzes/
│   ├── exercises/
│   ├── projects/
│   └── glossary/
├── docs/                   # نقشه محتوا و استاندارد تولید درس
└── README.md
```

## اتصال به AS Academy Core

برای توسعهٔ محلی، `AS-Academy-Core` را کنار این Repository checkout کنید. Android Host و ابزارهای Content از Core استفاده می‌کنند و منطق مشترک در Basic کپی نمی‌شود.

```text
workspace/
├── AS-Academy-Core/
└── AS-Academy-Basic/
```

قبل از انتشار Content باید Course Package با Validator موجود در Core بررسی شود.

## Version History

### 0.1.0 — Foundation

- ایجاد رسمی پروژه Basic
- تعریف Course ID و Package Name پایدار
- اتصال معماری به AS-Academy-Core
- تعریف چهار سطح اصلی دوره
- پایه‌گذاری نقشهٔ کامل مباحث مشترک برنامه‌نویسی
- پایه‌گذاری Course Package برای Lesson / Quiz / Exercise / Project / Glossary
- آغاز Android Host مستقل Basic

## وضعیت فعلی

پروژه در فاز **Foundation + Curriculum Architecture** قرار دارد. توسعهٔ محتوا از همین ساختار به‌صورت فصل‌به‌فصل تا تبدیل کامل به درس، مثال، تمرین، Quiz، آزمون و پروژه ادامه پیدا می‌کند.
