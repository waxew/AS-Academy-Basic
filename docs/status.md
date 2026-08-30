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
- Core compatibility patch: نسخه `1.0.1`
- Android Host Basic: نسخه `0.2.0` با `versionCode=2`
- Build pipeline: Validate → Compile → Lint → Assemble Debug → APK Artifact

## آمار محتوای واقعی

- سطح‌ها: 4 / 4
- فصل‌ها: 39
- درس واقعی: 157
- Quiz: 43
- سؤال Quiz: 222
- Exercise: 155
- Project: 14
- Glossary: 39 مدخل فعلی

## سطح ۱ — مبانی

10 فصل و 41 درس واقعی:

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

- آزمون جامع: `basic-qz-011`
- پروژه پایان سطح: `basic-prj-003`

## سطح ۲ — مقدماتی

12 فصل و 48 درس واقعی:

1. Collectionها: Array / List / Set / Map
2. String / Unicode / Parsing / Text Processing
3. Date / Time / UTC / Time Zone / Duration
4. Error / Exception / Logging / Recovery
5. File / Path / Encoding / Atomic Save / Streaming
6. JSON / CSV / XML / Schema / Validation
7. Terminal / Shell / Pipe / Script / Environment
8. Git Repository / Commit / Diff / Remote / Tag
9. Branch / Merge / Rebase / Pull Request
10. Debugging / Reproduce / Breakpoint / Stack Trace / Root Cause
11. Testing / AAA / Boundary / Test Double / Regression
12. README / Comment / Naming / Changelog / ADR

- آزمون جامع: `basic-qz-024`
- پروژه‌های میانی: `basic-prj-004` و `basic-prj-005`
- پروژه پایان سطح: `basic-prj-006`

## سطح ۳ — پیشرفته

11 فصل و 44 درس واقعی:

1. OOP
2. Functional Programming
3. Recursion
4. Data Structures
5. Search / Sort
6. Big-O و Complexity
7. Memory Management
8. Advanced Testing
9. Clean Code / Refactoring
10. SOLID
11. Design Patterns

- Quiz فصل‌ها: `basic-qz-025` تا `basic-qz-035`
- آزمون جامع: `basic-qz-036`
- پروژه‌های میانی: `basic-prj-007`، `basic-prj-008`، `basic-prj-009`
- پروژه پایان سطح: `basic-prj-010`

## سطح ۴ — تخصصی و بازار کار

6 فصل و 24 درس واقعی:

1. Software Architecture / Dependency Management / Versioning / Migration / ADR
2. Security / Threat Modeling / AuthN / AuthZ / Injection / Secure Delivery
3. Teamwork / Agile / Scrum / Kanban / Code Review / Incident/Postmortem
4. CI/CD / Release / Rollback / Open Source / Supply Chain / Artifact Provenance
5. Portfolio / GitHub / Resume / Career Gap Analysis
6. Technical Interview / Algorithm Patterns / Design Interview / STAR

- Quiz فصل‌ها: `basic-qz-037` تا `basic-qz-042`
- آزمون جامع نهایی کل Basic: `basic-qz-043`
- پروژه‌های تخصصی: `basic-prj-011`، `basic-prj-012`، `basic-prj-013`
- Final Capstone کل دوره: `basic-prj-014`

## Final Capstone

`basic-prj-014` یک Personal Operations Manager است که باید در یک زبان انتخابی پیاده‌سازی شود و این موارد را یکپارچه کند:

- Problem/Scope و Acceptance Criteria
- Data Model و Algorithm/Data Structure
- Architecture و Dependency Direction
- Offline Storage، Migration، Backup/Restore و Import/Export
- Security و Threat Model
- Git/Issue/Branch/PR Workflow
- Unit/Property/Integration/E2E/Regression Testing
- CI/CD و Release Evidence
- Documentation و ADR
- Complexity/Performance/Memory Review
- Security/Code Review
- Portfolio Case Study و Mock Interview Defense

## وضعیت پوشش آموزشی

چهار سطح اصلی اکنون مسیر آموزشی end-to-end دارند. «پوشش کامل اولیه» به معنی وجود درس واقعی، تمرین، ارزیابی و پروژه برای تمام فصل‌های اصلی است؛ enrichment همچنان ادامه پیدا می‌کند:

- Micro Quiz و Lesson Exam بیشتر
- Question Bank بزرگ‌تر
- Placement Test
- Weak Topic Review Queue
- Flashcard و Spaced Review
- مثال‌ها و Challengeهای بیشتر
- Rubric دقیق‌تر پروژه‌ها
- Diagram و Assetهای بصری
- Glossary گسترده‌تر
- بانک سؤال مصاحبه بزرگ‌تر

## فاز فعلی

`Four-level curriculum covered → Final validation/build → Enrichment and release hardening`

## معیار Done

عنوان یا فایل خالی Done محسوب نمی‌شود. فقط محتوایی در آمار تکمیل وارد می‌شود که آموزش واقعی، مثال/سناریو، تمرین یا ارزیابی معتبر داشته باشد. Course Validator و GitHub Actions مرجع فنی صحت Package و Android Host هستند.
