# Basic 0.3.0 — Release Validation Status

آخرین به‌روزرسانی: 2026-08-30

## مبنای انتشار

- `AS-Academy-Core 1.2.0` روی `main` ادغام شده است.
- Basic به `minimumCoreVersion = 1.2.0` ارتقا یافته است.
- Android Host نسخه `0.3.0` با `versionCode = 5` است.
- Package ID ثابت `com.asdevelopers.academy.basic` حفظ شده است.

## دامنه 0.3.0

- Placement Test با نتیجه Persist شده در Room
- Placement Summary و انتخاب اولین درس سطح پیشنهادی
- Weak Topic Review بر اساس Quiz history و `weakTags`
- Glossary-driven Flashcard Review
- Spaced Review با `AGAIN / HARD / GOOD / EASY`
- Session snapshot با Batch پیش‌فرض 20 کارت
- Flashcard Progress در Room schema v4
- Review Progress در Backup schema v3
- Routeهای مشترک Placement / Weak Review / Flashcard Review

## Quality Gate موردنیاز قبل از Merge

این Branch فقط وقتی به `main` منتقل می‌شود که Workflow رسمی Repository همه مراحل زیر را با موفقیت بگذراند:

1. Course Package Validation با Validator رسمی Core
2. Course Bundle Compilation
3. Android Compile
4. Android Lint
5. Debug APK Assembly
6. Upload APK Artifact

در صورت شکست هر مرحله، همان خطا قبل از Merge اصلاح می‌شود. این سند وضعیت انتشار را ثبت می‌کند و جایگزین نتیجه CI نیست.
