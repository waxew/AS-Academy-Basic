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

New lessons, chapters, quizzes, exercises, projects, glossary data and educational references are edited there. The duplicated `AS-Academy-Basic/course/basic` directory has been removed from the 1.1 development line; the former 1.0.0 copy remains available through Git history and the stable release tag.

### AS-Academy-Basic
Owns only application identity and Course-specific host configuration:

- stable `applicationId`: `com.asdevelopers.academy.basic`
- versionCode/versionName
- app branding/capability choices that are genuinely Basic-specific
- Android launcher/entry configuration
- build scripts that compile the canonical MainCourse package

Shared UI, learning logic or editable curriculum content must not be copied into Basic.

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

`scripts/prepare-course.sh` and `scripts/prepare-course.bat` fail if `MainCourse/courses/basic/course` is unavailable. There is no local Course Package fallback in Basic.

## Update compatibility

The 1.0.0 signed release used versionCode 9. The 1.1 development line starts at versionCode 10. Package identity and the existing Android signing JKS must remain unchanged for every future publish APK so installed user data can survive updates.

## Migration status

1. MainCourse canonical Basic package — migrated and validated with Core.
2. MainUi executable Android library — active, compile/lint gated and exposing the shared presentation facade.
3. Basic build — consumes Core 1.3 + MainUi 0.1.0 and compiles its Course Package exclusively from MainCourse.
4. Shared Theme/AppShell/Home/Catalog/Lesson/Quiz/Exercise/Project/Settings/Review presentation — routed through MainUi.
5. Core 1.3 Learning Catalog — integrated into Basic navigation and Drawer.
6. Legacy local Basic Course Package — removed from the 1.1 development line.
7. Android identity — preserved as `com.asdevelopers.academy.basic`; versionCode advanced from 9 to 10 for update compatibility.
