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
- GitHub Actions Quality Gate: فعال
- Shared Quiz/Exercise/Project UI در Core: انجام شده
- public RoomDatabase dependency در Core: اصلاح و CI آن سبز شده
- Build واقعی Basic روی main: Validate + Compile + Lint + Assemble Debug + Artifact موفق

## آمار محتوای واقعی در شاخه توسعه فعلی

- سطح‌ها: 4 / 4 تعریف شده
- فصل‌ها: 39 فصل تعریف شده
- درس واقعی: 89
- Quiz: 24
- سؤال Quiz: 126
- Exercise: 87
- Project: 6
- Glossary: 39 مدخل فعلی

## پوشش سطح مبانی

سطح مبانی در 10 فصل با 41 درس واقعی پوشش داده شده است:

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

درس `basic-fnd-041` جمع‌بندی سطح، Quiz `basic-qz-011` آزمون جامع مبانی و Project `basic-prj-003` پروژه پایان سطح است.

## پوشش سطح مقدماتی

سطح مقدماتی در 12 فصل با 48 درس واقعی پوشش داده شده است:

1. Array / List / Set / Map و انتخاب Collection
2. String، Unicode، Parsing و Text Processing
3. Date/Time، Instant، UTC، Time Zone و Duration
4. Error/Exception، Fail Fast، Logging و Recovery Strategy
5. File/Path، Encoding، Atomic Save و Streaming
6. JSON / CSV / XML، Schema و Validation
7. Terminal / Shell / Pipe / Redirection / Environment / Script
8. Git Repository / Commit / Diff / Remote / Tag / .gitignore
9. Branch / Merge / Rebase / Pull Request / Code Review مقدماتی
10. Debugging / Reproduce / Breakpoint / Stack Trace / Root Cause
11. Testing / AAA / Boundary / Test Double / Regression / Test Pyramid
12. README / Comment / Naming / Changelog / ADR و مستندسازی فنی

Quiz `basic-qz-024` آزمون جامع پایان سطح مقدماتی و Project `basic-prj-006` پروژه پایان سطح است. دو پروژه میانی `basic-prj-004` و `basic-prj-005` نیز Collection/String/DateTime و Error/File/Data Format را یکپارچه می‌کنند.

## معنی «پوشش اولیه کامل»

مبانی و مقدماتی اکنون مسیر آموزشی end-to-end دارند، اما enrichment ادامه خواهد داشت:

- Micro Quiz و Lesson Exam بیشتر
- Question Bank بزرگ‌تر
- Flashcard و Spaced Review
- Placement Test
- Weak Topic review queue
- مثال‌ها و سناریوهای بیشتر
- Challenge Exercise بیشتر
- Rubric دقیق‌تر پروژه‌ها
- Diagram و Assetهای بصری مناسب
- Glossary گسترده‌تر برای سطح مقدماتی

## فاز فعلی

`Foundation complete → Fundamentals covered → Beginner covered → Advanced next`

مرحله بعد روی OOP، Functional Programming، Recursion، Data Structures، Search/Sort، Big-O، Memory، Advanced Testing، Clean Code/Refactoring، SOLID و Design Patterns متمرکز است.

## معیار گزارش پیشرفت

عنوان یا فایل خالی «تکمیل» محسوب نمی‌شود. فقط محتوایی در آمار تکمیل وارد می‌شود که آموزش واقعی، مثال، تمرین یا ارزیابی معتبر داشته باشد و با قرارداد Course Package سازگار باشد. CI و Validator مرجع فنی صحت بسته هستند.
