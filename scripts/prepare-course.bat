@echo off
rem MainCourse is the canonical educational source; Core validates and compiles it for the Basic app.
setlocal

set "BASIC_DIR=%~dp0.."
if not defined ACADEMY_CORE_DIR set "ACADEMY_CORE_DIR=%BASIC_DIR%\..\AS-Academy-Core"
if not defined ACADEMY_MAIN_COURSE_DIR set "ACADEMY_MAIN_COURSE_DIR=%BASIC_DIR%\..\AS-Academy-MainCourse"
set "COURSE_DIR=%ACADEMY_MAIN_COURSE_DIR%\courses\basic\course"
set "OUTPUT_FILE=%BASIC_DIR%\app\src\main\assets\basic-course.json"

if not exist "%ACADEMY_CORE_DIR%\gradlew.bat" (
  echo AS-Academy-Core Gradle wrapper not found at: %ACADEMY_CORE_DIR%
  exit /b 2
)

rem Do not fall back to the legacy Basic copy; that would recreate two sources of truth.
if not exist "%COURSE_DIR%\manifest.json" (
  echo Canonical Basic Course Package not found at: %COURSE_DIR%
  echo Clone AS-Academy-MainCourse next to Basic or set ACADEMY_MAIN_COURSE_DIR.
  exit /b 3
)

if not exist "%BASIC_DIR%\app\src\main\assets" mkdir "%BASIC_DIR%\app\src\main\assets"

call "%ACADEMY_CORE_DIR%\gradlew.bat" -p "%ACADEMY_CORE_DIR%" :tools:run --args="validate \"%COURSE_DIR%\"" --stacktrace
if errorlevel 1 exit /b %errorlevel%

call "%ACADEMY_CORE_DIR%\gradlew.bat" -p "%ACADEMY_CORE_DIR%" :tools:run --args="compile \"%COURSE_DIR%\" \"%OUTPUT_FILE%\"" --stacktrace
if errorlevel 1 exit /b %errorlevel%

echo Basic Course Bundle ready from MainCourse: %OUTPUT_FILE%
endlocal
