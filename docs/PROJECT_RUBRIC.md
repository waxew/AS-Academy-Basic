# Project Assessment Rubric

این Rubric برای ارزیابی پروژه‌های عملی `AS-Academy-Basic` استفاده می‌شود و بر `ProjectMilestone.acceptanceCriteria` در Core سوار است. معیارها باید قابل مشاهده و قابل اثبات باشند؛ صرفاً «کار می‌کند» برای قبولی کافی نیست.

## Rubric صد امتیازی

| محور | امتیاز | معیار |
|---|---:|---|
| Correctness & Requirements | 20 | قابلیت‌های خواسته‌شده، edge caseها و Acceptance Criteria درست اجرا شده‌اند. |
| Design & Architecture | 15 | تفکیک مسئولیت، dependency direction و مدل داده قابل دفاع است. |
| Testing | 15 | تست‌های مناسب برای مسیر عادی، مرزی، خطا و regression وجود دارد. |
| Error Handling & Reliability | 10 | failure path، recovery و رفتار ورودی نامعتبر کنترل شده است. |
| Security & Data Safety | 10 | validation، secret/privacy، دسترسی و داده حساس متناسب با پروژه بررسی شده است. |
| Performance & Complexity | 10 | انتخاب الگوریتم/ساختمان داده و هزینه زمان/حافظه قابل توضیح است. |
| Code Quality & Maintainability | 10 | نام‌گذاری، خوانایی، duplication، SOLID/Clean Code و refactoring مناسب است. |
| Documentation & Evidence | 10 | README، تصمیم‌ها، test evidence، release evidence و نحوه اجرا قابل دنبال‌کردن است. |

## سطح نتیجه

- `90-100`: ممتاز؛ آماده Portfolio/Interview Defense.
- `80-89`: قوی؛ فقط اصلاحات محدود لازم است.
- `70-79`: قابل قبول؛ پروژه پاس شده اما debt مشخص دارد.
- `60-69`: نیازمند اصلاح؛ milestoneهای ضعیف باید دوباره تحویل شوند.
- `<60`: پروژه پاس نشده است.

## شروط Blocker

حتی اگر مجموع امتیاز ۷۰ یا بیشتر باشد، موارد زیر می‌توانند پروژه را Block کنند:

- از دست رفتن یا خراب‌شدن داده در سناریوی عادی یا Update.
- secret واقعی داخل source/repository.
- نقص امنیتی واضح و قابل سوءاستفاده در scope پروژه.
- نبود هیچ تست برای منطق اصلی در پروژه‌ای که Testing جزو Acceptance Criteria است.
- ناتوانی در Build/Run مطابق مستندات.
- ادعای Feature یا Evidence جعلی/غیرقابل بازتولید.

## استفاده در Milestoneها

هر Milestone باید حداقل یک Acceptance Criterion قابل بررسی داشته باشد. برای مثال:

- «Search ساخته شود» ضعیف است.
- «Search روی ۱۰٬۰۰۰ رکورد نتیجه درست برگرداند و رفتار ورودی خالی تعریف شده باشد» قابل ارزیابی است.

در Final Capstone، Rubric روی کل محصول اعمال می‌شود و هر milestone علاوه بر معیار محلی، Evidence مرتبط خود را نگه می‌دارد.

## Evidence پیشنهادی

- Test report
- CI run
- Commit/PR reference
- Screenshot فقط در موارد UI
- Benchmark یا Complexity analysis
- Threat model / Security checklist
- Migration/Backup evidence
- Release checksum
- ADR یا design note
- Portfolio case study

هدف Rubric تبدیل پروژه از «تمرین کدنویسی» به خروجی مهندسی قابل دفاع است.
