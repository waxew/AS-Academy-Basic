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
- public RoomDatabase dependency در Core: اصلاح شده و Core CI سبز است
- Build واقعی Basic: Validate + Compile + Lint + Assemble Debug + APK Artifact موفق

## آمار محتوای واقعی در شاخه توسعه فعلی

- سطح‌ها: 4 / 4 تعریف شده
- فصل‌ها: 39 فصل تعریف شده
- درس واقعی: 133
- Quiz: 36
- سؤال Quiz: 182
- Exercise: 131
- Project: 10
- Glossary: 39 مدخل فعلی

## سطح مبانی

10 فصل و 41 درس واقعی. `basic-qz-011` آزمون جامع و `basic-prj-003` پروژه پایان سطح است.

## سطح مقدماتی

12 فصل و 48 درس واقعی شامل Collections، String، Date/Time، Error Handling، File، JSON/CSV/XML، CLI، Git/GitHub، Branch/Merge/PR، Debugging، Testing و Documentation. `basic-qz-024` آزمون جامع و `basic-prj-006` پروژه پایان سطح است.

## سطح پیشرفته

11 فصل و 44 درس واقعی:

1. OOP: Object/Class، Encapsulation، Composition/Inheritance/Polymorphism و Interface
2. Functional Programming: Pure Function، Immutability، Higher-order Function و Composition
3. Recursion: Base Case، Call Stack، Tree Recursion، Iteration/Memoization
4. Data Structures: ADT، Stack/Queue، Linked List/Hash Table، Tree/Heap/Graph
5. Search/Sort: Linear/Binary Search، Insertion/Selection، Merge/Quick Sort و انتخاب Algorithm
6. Complexity: Big-O، Best/Average/Worst، Space Complexity و تحلیل Pipeline
7. Memory: Stack/Heap، GC/Ownership، Leak/Lifecycle و Profiling
8. Advanced Testing: Integration/Contract، E2E، Determinism و Property/Mutation Testing
9. Clean Code/Refactoring: Cohesion/Coupling، Code Smell، Refactor امن و Boundary Design
10. SOLID: SRP، OCP، LSP، ISP و DIP
11. Design Patterns: Pattern Language، Factory/Builder، Adapter/Decorator/Facade و Strategy/Observer/Command

ارزیابی سطح پیشرفته:
- Quiz فصل‌ها: `basic-qz-025` تا `basic-qz-035`
- آزمون جامع: `basic-qz-036`
- پروژه‌های میانی: `basic-prj-007`، `basic-prj-008`، `basic-prj-009`
- Capstone پایان Advanced: `basic-prj-010`

## معنی «پوشش اولیه کامل»

سه سطح اول اکنون مسیر آموزشی end-to-end دارند. Enrichment بعدی شامل Micro Quiz، Question Bank گسترده‌تر، Flashcard، Placement Test، Weak Topic Review، مثال و Challenge بیشتر، Rubric دقیق پروژه و Diagram/Asset است.

## فاز فعلی

`Foundation complete → Fundamentals covered → Beginner covered → Advanced covered → Specialist next`

مرحله بعد روی Software Architecture، Dependency/Versioning، Security، Teamwork/Agile/Code Review، CI/CD، Open Source، Portfolio/Resume و Technical Interview متمرکز است.

## معیار گزارش پیشرفت

عنوان یا فایل خالی «تکمیل» محسوب نمی‌شود. فقط محتوای دارای آموزش واقعی، مثال، تمرین یا ارزیابی معتبر در آمار تکمیل وارد می‌شود. Validator و CI مرجع فنی صحت Course Package هستند.
