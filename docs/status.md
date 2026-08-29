# وضعیت فعلی AS Academy Basic

آخرین بازبینی: 2026-08-30

## معماری

- اتصال به `AS-Academy-Core`: انجام شده
- Course Package استاندارد: انجام شده
- Android Host Compose: انجام شده
- Drawer / Settings / Theme / Navigation: از Core مصرف می‌شود
- Quiz / Exercise / Project workflow: از Core مصرف می‌شود
- Room persistence برای Quiz History / Exercise Draft / Activity Completion / Project Progress: متصل شده
- Course Validator / Compiler: متصل شده
- GitHub Actions Quality Gate: تعریف شده
- Shared Quiz/Exercise/Project UI در Core: انجام شده
- مشکل public RoomDatabase dependency در Core: اصلاح شده و تحت CI است

## آمار محتوای واقعی

- سطح‌ها: 4 / 4 تعریف شده
- فصل‌ها: 39 فصل تعریف شده
- درس واقعی: 41
- Quiz: 11
- سؤال Quiz: 66
- Exercise: 39
- Project: 3
- Glossary: 39 مدخل

## پوشش سطح مبانی

تمام 10 فصل سطح مبانی اکنون حداقل یک بسته آموزشی واقعی دارند:

1. سواد رایانه و سیستم‌عامل
2. رشته‌ها و بازار کار برنامه‌نویسی
3. منطق و حل مسئله
4. الگوریتم، فلوچارت و شبه‌کد
5. متغیرها و انواع داده
6. عملگرها و عبارت‌ها
7. ورودی و خروجی
8. شرط‌ها و تصمیم‌گیری
9. حلقه‌ها و تکرار
10. توابع و تفکیک مسئولیت

برای بخش‌های اصلی این سطح Lesson، Example، Exercise، Quiz و Project ایجاد شده است. درس `basic-fnd-041` جمع‌بندی سطح، Quiz `basic-qz-011` آزمون جامع مبانی و Project `basic-prj-003` پروژه پایان سطح است.

## معنی «پوشش اولیه کامل»

این وضعیت به معنی پایان نهایی تولید محتوا نیست. سطح مبانی از نظر مسیر آموزشی و پوشش مفاهیم اصلی بسته شده است، اما در فازهای بعدی موارد زیر روی همین Stable IDها و ساختار افزوده می‌شوند:

- Micro Quiz بیشتر داخل درس‌ها
- Lesson Exam و Chapter Exam گسترده‌تر
- Question Bank بزرگ‌تر
- Flashcard و Spaced Review
- Placement Test
- Weak Topic review queue
- مثال‌ها و سناریوهای بیشتر
- تمرین Challenge بیشتر
- Rubric دقیق‌تر برای پروژه‌ها
- محتوای تصویری/Diagram در موضوعات مناسب

## فاز فعلی

`Foundation complete → Fundamentals v0.1 covered → Beginner content next`

قدم محتوایی بعدی ورود عمیق به سطح مقدماتی است: Collections، String، Date/Time، Error Handling، Files، JSON/CSV/XML، CLI، Git/GitHub، Branch/Merge/PR، Debugging، Testing و Documentation.

## معیار گزارش پیشرفت

عنوان یا فایل خالی «تکمیل» محسوب نمی‌شود. فقط محتوایی در آمار تکمیل وارد می‌شود که آموزش واقعی، مثال، تمرین یا ارزیابی معتبر داشته باشد و با قرارداد Course Package سازگار باشد. CI و Validator مرجع فنی صحت بسته هستند.
