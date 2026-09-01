# AS Academy Basic — Architecture 2026

Basic is a thin Course App in the four-repository AS Academy architecture.

```text
AS-Academy-Basic
  ├─ consumes AS-Academy-MainUi   -> presentation / shared screens
  ├─ consumes AS-Academy-Core     -> runtime / engine / persistence / navigation contracts
  └─ compiles AS-Academy-MainCourse/courses/basic/course -> packaged course asset
```

## Source-of-truth rules

### AS-Academy-Core
Owns reusable runtime and engineering behavior: Course Contract, validator/compiler, navigation contracts, Room/database, progress, completion, quiz history, adaptive learning, settings, reminders, backup/update services and other shared engines.

### AS-Academy-MainUi
Owns reusable visual behavior: app shell, Drawer/Profile, design system, common home/catalog/search/reader/quiz/exercise/project/progress/settings surfaces and wiring of visible actions to Core repositories.

### AS-Academy-MainCourse
Owns the curriculum. The canonical Basic package is:

`courses/basic/course`

New lessons, chapters, quizzes, exercises, projects, glossary data and educational references must be edited there first. `AS-Academy-Basic/course/basic` is a legacy 1.0.0 snapshot and is not a valid source for new content after migration.

### AS-Academy-Basic
Owns only application identity and Course-specific host configuration:

- stable `applicationId`: `com.asdevelopers.academy.basic`
- versionCode/versionName
- app branding/capability choices that are genuinely Basic-specific
- Android launcher/entry configuration
- build scripts that compile the canonical MainCourse package

Shared UI or learning logic must not be copied into Basic.

## Build inputs

Sibling checkout is the default development layout:

```text
AS-Academy-Core/
AS-Academy-MainUi/
AS-Academy-MainCourse/
AS-Academy-Basic/
```

Optional path overrides:

- `ACADEMY_CORE_DIR`
- `ACADEMY_MAIN_UI_DIR`
- `ACADEMY_MAIN_COURSE_DIR`

`scripts/prepare-course.sh` and `scripts/prepare-course.bat` fail if `MainCourse/courses/basic/course` is unavailable. They deliberately do not fall back to the legacy Basic course directory.

## Update compatibility

The 1.0.0 signed release used versionCode 9. The 1.1 development line starts at versionCode 10. Package identity and the existing Android signing JKS must remain unchanged for every future publish APK so installed user data can survive updates.

## Migration status

1. MainCourse canonical Basic package — migration/validation in progress.
2. MainUi executable Android library — bootstrapped with Core 1.3 facade and CI.
3. Basic build — switched to Core 1.3 + MainUi 0.1.0 and MainCourse content input.
4. Old Core UI calls — temporarily supported through the documented compatibility adapter; each shared surface will move behind MainUi without changing Course behavior.
5. Core 1.3 Learning Catalog — available for the MainUi-backed 1.1 integration.
