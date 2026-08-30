# Basic ↔ AS Academy Core Compatibility

این فایل قرارداد وابستگی بین `AS-Academy-Basic` و `AS-Academy-Core` را ثبت می‌کند تا Course Host و Content Package در نسخه‌های بعدی update-friendly باقی بمانند.

## Current compatibility

- Basic Android/Course version: `0.2.0`
- Basic Android `versionCode`: `2`
- Required Core: `>= 1.0.1`
- Course schema: `1`
- Android package: `com.asdevelopers.academy.basic`
- Course ID: `basic`

## Shared responsibilities owned by Core

Basic این قابلیت‌ها را دوباره پیاده‌سازی نمی‌کند:

- Navigation و Back Stack
- Design System و Theme
- Drawer / Profile / Settings
- Room Database و Migrationهای داده کاربر
- Lesson Progress و Continue Learning
- Quiz / Exercise / Project runtime و UI
- Search / Bookmark / Note
- Achievement
- Backup / Restore
- Content Loader / Validator / Compiler / Updater
- Course schema و Stable-ID contract

هر تغییر عمومی باید ابتدا در `AS-Academy-Core` اعمال و سپس توسط Courseها مصرف شود.

## 1.0.1 compatibility patch

Core `1.0.1` دو مورد لازم برای Basic را تثبیت می‌کند:

1. `RoomDatabase` به‌صورت dependency عمومی Core در اختیار Host قرار می‌گیرد تا `AcademyDatabase` بدون classpath ناقص قابل مصرف باشد.
2. `EXERCISE_LINK` به‌عنوان alias سازگار Course Packageهای اولیه خوانده می‌شود و همان رفتار canonical `EXERCISE` را دارد. Content جدید باید به‌تدریج `EXERCISE` تولید کند، اما Packageهای قبلی نباید در Update از کار بیفتند.

## Update rules

- `applicationId` تغییر نمی‌کند.
- `versionCode` فقط افزایش می‌یابد.
- Stable ID درس/تمرین/آزمون/پروژه بعد از انتشار تغییر یا reuse نمی‌شود.
- داده کاربر با destructive migration حذف نمی‌شود.
- Course Package قبل از APK build با Validator و Compiler همان Core بررسی می‌شود.
- Release جدید باید روی داده نسخه قبلی Migration/Restore test داشته باشد.
- Signing key خصوصی داخل Repository قرار نمی‌گیرد و برای تمام releaseهای همان app ثابت می‌ماند.

## Quality gate

هر تغییر قابل انتشار باید این مسیر را بگذراند:

`Course Validate → Course Compile → Android Lint → Assemble → Artifact Verification`

در فاز Release، signature verification، SHA-256 و release notes نیز به این مسیر افزوده می‌شوند.
