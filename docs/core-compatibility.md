# Basic ↔ AS Academy Core Compatibility

این فایل قرارداد وابستگی بین `AS-Academy-Basic` و `AS-Academy-Core` را ثبت می‌کند تا Course Host و Content Package در نسخه‌های بعدی update-friendly باقی بمانند.

## Current compatibility

- Basic Android/Course version: `0.3.0`
- Basic Android `versionCode`: `3`
- Basic curriculum version: `0.2.0`
- Required Core: `>= 1.1.0`
- Course schema: `1`
- Core Room database schema: `4`
- Android package: `com.asdevelopers.academy.basic`
- Course ID: `basic`

`curriculumVersion` در 0.3.0 ثابت مانده چون ترتیب چهار سطح و 39 فصل تغییر نکرده است. افزایش Course/Host version مربوط به Enrichment محتوایی، Flashcard و Runtime مرور است.

## Shared responsibilities owned by Core

Basic این قابلیت‌ها را دوباره پیاده‌سازی نمی‌کند:

- Navigation و Back Stack
- Design System و Theme
- Drawer / Profile / Settings
- Room Database و Migrationهای داده کاربر
- Lesson Progress و Continue Learning
- Quiz / Exercise / Project runtime و UI
- Flashcard contract / Deck UI / Spaced Review Engine
- Flashcard review persistence، Due queue و Session snapshot
- Search / Bookmark / Note
- Achievement
- Backup / Restore شامل Flashcard review history
- Content Loader / Importer / Validator / Compiler / Updater
- Course schema و Stable-ID contract

هر تغییر عمومی باید ابتدا در `AS-Academy-Core` اعمال و سپس توسط Courseها مصرف شود.

## Core 1.0.1 compatibility patch

Core `1.0.1` دو مورد لازم برای نسل قبلی Basic را تثبیت کرد:

1. `RoomDatabase` به‌صورت dependency عمومی Core در اختیار Host قرار گرفت تا `AcademyDatabase` بدون classpath ناقص قابل مصرف باشد.
2. `EXERCISE_LINK` به‌عنوان alias سازگار Course Packageهای اولیه خوانده می‌شود و همان رفتار canonical `EXERCISE` را دارد. Content جدید باید `EXERCISE` تولید کند ولی Package قدیمی همچنان قابل خواندن است.

## Core 1.1.0 compatibility contract

Core `1.1.0` قابلیت مشترک Flashcard را به‌صورت additive و backward-compatible اضافه می‌کند:

- `CourseCapabilities.flashcards` با default فعال
- `CourseBundle.flashcards` با `emptyList()` پیش‌فرض
- مدل `Flashcard` با Stable ID و اتصال اجباری به Lesson واقعی
- Search indexing برای Front/Back/Hint/Tag
- `FlashcardReviewEngine` با Ratingهای Again/Hard/Good/Easy
- `FlashcardDeck` مشترک Compose
- مقصد عمومی `academy/flashcards`
- `FlashcardReviewRepository`
- Room table `flashcard_review_state`
- Migration غیرتخریبی `MIGRATION_3_4`
- Seed کارت‌های تازه با `INSERT IGNORE` هنگام `CoursePackageImporter.import()`
- حفظ سابقه مرور در Backup/Restore
- Authoring پوشه‌ای object/array برای مجموعه‌های Course

Basic فقط 56 Flashcard اختصاصی دوره و Host wiring را نگه می‌دارد؛ الگوریتم Review، DB، Navigation و UI در Core هستند.

## Update rules

- `applicationId` تغییر نمی‌کند.
- `versionCode` فقط افزایش می‌یابد.
- Stable ID درس/تمرین/آزمون/پروژه/Flashcard بعد از انتشار تغییر یا reuse نمی‌شود.
- داده کاربر با destructive migration حذف نمی‌شود.
- تغییر Flashcard ID معادل کارت جدید است و Review History قبلی دیگر به آن متصل نخواهد بود.
- Course Package قبل از APK build با Validator و Compiler همان Core بررسی می‌شود.
- `minimumCoreVersion` باید هر قابلیت جدید Contract/Runtime را دقیق منعکس کند.
- Release جدید باید روی داده نسخه قبلی Migration/Restore test داشته باشد.
- Signing key خصوصی داخل Repository قرار نمی‌گیرد و برای تمام Releaseهای همان app ثابت می‌ماند.

## Basic 0.2.0 → 0.3.0 update path

مسیر ارتقا بدون حذف نصب طراحی شده است:

1. Android package ثابت می‌ماند.
2. `versionCode` از 2 به 3 افزایش می‌یابد.
3. Core database از v3 به v4 با `MIGRATION_3_4` ارتقا می‌یابد.
4. Migration فقط جدول Flashcard review را ایجاد می‌کند و به Progress/Quiz/Note/Draft/Project/Achievement قبلی دست نمی‌زند.
5. پس از Load موفق Course، `CoursePackageImporter` Legacy claim، Flashcard seed و Search rebuild را در یک Transaction انجام می‌دهد.
6. کارت‌های جدید `dueAt=0` می‌گیرند؛ State قبلی به‌دلیل Conflict IGNORE overwrite نمی‌شود.

## Quality gate

هر تغییر قابل انتشار باید این مسیر را بگذراند:

`Course Validate → Course Compile → Core Contract Tests → Android Lint → Assemble → Room Schema Verification → Artifact Verification`

در فاز Release، Migration instrumentation test، signature verification، SHA-256 و release notes نیز به این مسیر افزوده می‌شوند.
