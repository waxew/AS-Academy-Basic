# Learning Quality Workflow

این سند استاندارد کیفیت یادگیری دوره `AS-Academy-Basic` را تعریف می‌کند. هدف فقط پوشش سرفصل نیست؛ هر یادگیرنده باید بتواند سطح شروع مناسب، نقاط ضعف و برنامه مرور بعدی خود را پیدا کند.

## چرخه اصلی

`Placement -> Learn -> Practice -> Quiz -> Weak Topic Review -> Spaced Review -> Project -> Exam -> Evidence`

در Basic 0.3.0 این چرخه فقط مستند نیست؛ Placement، Weak Topic Review و Flashcard Review به Android Host واقعی و Persistence مشترک Core متصل شده‌اند.

## آزمون تعیین سطح

آزمون `basic-qz-placement-001` یک آزمون جامع ۳۲ سؤالی است که چهار سطح دوره را پوشش می‌دهد. سؤال‌های پیشرفته‌تر وزن بیشتری دارند تا صرفاً حفظ مفاهیم ابتدایی باعث قرارگیری اشتباه در سطح بالا نشود.

### تفسیر نمره

- `0-34%`: شروع از **مبانی** و تکمیل مسیر کامل.
- `35-54%`: شروع از **مقدماتی**؛ موضوعات ضعیف مبانی قبل از ادامه مرور شوند.
- `55-74%`: ورود به **پیشرفته** با مرور هدفمند `weakTags`.
- `75-89%`: ورود به **تخصصی/بازار کار** همراه آزمون‌های فصل و پروژه‌های پیشرفته.
- `90-100%`: مسیر فشرده؛ آزمون‌های جامع، پروژه‌های سطح بالا و Final Capstone اولویت دارند.

نمره به‌تنهایی برای Skip کردن درس کافی نیست. اگر یک Tag در پاسخ‌های غلط تکرار شود، همان موضوع باید در Weak Topic Review برگردد.

### رفتار Android در 0.3.0

1. کاربر Placement Test را مانند یک Quiz واقعی حل می‌کند.
2. نتیجه و `weakTags` ابتدا در Room مشترک ذخیره می‌شوند.
3. Placement Summary نتیجه آخر Persist شده را می‌خواند؛ Rotation یا Restart آن را از بین نمی‌برد.
4. سطح شروع توسط Policy چهارسطحی Core انتخاب می‌شود.
5. اولین درس سطح پیشنهادی با ترتیب رسمی Level/Chapter/Lesson از `LearningPathEngine` پیدا می‌شود.
6. کاربر می‌تواند مستقیم وارد Weak Topic Review شود.

## Weak Topic Review

Quiz Engine در هر `QuizScore` مجموعه `weakTags` را تولید می‌کند. Core این Tagها را از تاریخچه واقعی آزمون همان Course می‌خواند، در چند Attempt تجمیع می‌کند و درس‌هایی را که بیشترین هم‌پوشانی با ضعف تکرارشونده دارند رتبه‌بندی می‌کند.

Basic هیچ SQL، parsing یا الگوریتم رتبه‌بندی اختصاصی برای این قابلیت ندارد.

قاعده پیشنهادی آموزشی:

1. ضعف یک‌باره: مرور خلاصه و یک تمرین.
2. ضعف دوباره: بازخوانی درس + تمرین Medium.
3. ضعف سه‌بار یا بیشتر: بازگشت کامل به درس + Quiz مجدد + Challenge.
4. ضعف بعد از Project: ایجاد Review Task اجباری قبل از سطح بعد.

## Flashcard و Spaced Review

Glossary منبع حقیقت واژگان است. Flashcardهای پایه از Glossary مشتق می‌شوند تا تعریف یک اصطلاح در چند محل تکرار نشود.

هر کارت شامل:

- Term
- Definition
- Alias فارسی/انگلیسی
- Related Lesson IDs
- Tags

پس از پاسخ کاربر یکی از چهار Rating ثبت می‌شود:

- `AGAIN`: فراموش شده؛ مرور سریع مجدد.
- `HARD`: یادآوری سخت؛ فاصله کم افزایش یابد.
- `GOOD`: پاسخ صحیح معمولی؛ فاصله استاندارد افزایش یابد.
- `EASY`: تسلط بالا؛ فاصله سریع‌تر افزایش یابد.

### رفتار Session در 0.3.0

- کارت‌های دیده‌نشده نیز برای اولین مرور `due` هستند.
- هر Session به‌صورت پیش‌فرض حداکثر ۲۰ کارت دارد تا جلسه بیش از حد طولانی نشود.
- فهرست کارت‌ها هنگام شروع Session snapshot می‌شود؛ Rating یک کارت ترتیب کارت‌های بعدی را جابه‌جا نمی‌کند.
- زمان مرور بعدی در Core بر اساس UTC epoch day محاسبه می‌شود.
- Progress هر کارت در Room schema v4 ذخیره می‌شود.
- Backup schema v3 برنامه مرور را نیز Export/Restore می‌کند.
- Migration دیتابیس destructive نیست و داده نسخه‌های قبلی حفظ می‌شود.

## Lesson Quality Minimum

هر درس کامل باید حداقل این اجزا را داشته باشد:

1. هدف یادگیری و پیش‌نیاز
2. توضیح شهودی
3. توضیح فنی
4. مثال
5. نکته یا خطای رایج
6. تمرین مرتبط
7. Hint/Solution/Explanation
8. Quiz یا اتصال به ارزیابی فصل
9. Tagهای قابل استفاده برای Weak Topic Review
10. ارتباط با پروژه یا کاربرد واقعی در موضوعات مناسب

## Assessment Layers

- Micro Quiz: 3 تا 5 سؤال برای feedback سریع
- Lesson/Topic Quiz: حدود 5 تا 12 سؤال
- Chapter Exam: پوشش چند درس با سؤال مفهومی و کاربردی
- Level Exam: سنجش end-to-end سطح
- Placement Test: انتخاب نقطه شروع
- Depth Assessment: سنجش reasoning و trade-off هر سطح
- Final Exam: پوشش کل دوره
- Project/Capstone: ارزیابی توانایی ساخت و دفاع از راه‌حل

## Definition of Learning Done

یک موضوع فقط وقتی «یادگرفته‌شده» محسوب می‌شود که:

- Lesson تکمیل شده باشد.
- Quiz حداقل نمره قبولی را بگیرد.
- Exercise اصلی حل شده باشد.
- ضعف تکرارشونده باز نمانده باشد.
- اگر موضوع پروژه‌محور است، Acceptance Criteria مرتبط پاس شده باشد.

این تعریف از Complete شدن صرفاً با بازکردن صفحه درس جلوگیری می‌کند.

## مالکیت معماری

Basic فقط Course Content، Stable IDها و Branding را نگه می‌دارد. این قابلیت‌ها متعلق به `AS-Academy-Core >= 1.2.0` هستند:

- Placement policy/result repository
- Weak Topic Review engine/repository/UI
- Spaced Review engine/repository/UI
- Flashcard persistence و Backup/Restore
- Adaptive navigation routes
- first-lesson lookup برای سطح پیشنهادی

این تفکیک باید در همه Courseهای بعدی AS Academy حفظ شود.
