@echo off
rem این Script ویندوز Course Package را با Gradle Wrapper خود AS-Academy-Core Validate و Compile می‌کند.
setlocal

rem مسیر Basic از محل خود Script ساخته می‌شود و به Current Directory وابسته نیست.
set "BASIC_DIR=%~dp0.."
rem کاربر می‌تواند ACADEMY_CORE_DIR را تنظیم کند؛ در غیر این صورت Repository کنار Basic فرض می‌شود.
if not defined ACADEMY_CORE_DIR set "ACADEMY_CORE_DIR=%BASIC_DIR%\..\AS-Academy-Core"
rem Android Loader این Bundle تولیدشده را در assets می‌خواند.
set "OUTPUT_FILE=%BASIC_DIR%\app\src\main\assets\basic-course.json"

rem نبود Wrapper Core باید Build را متوقف کند تا Bundle نامعتبر وارد APK نشود.
if not exist "%ACADEMY_CORE_DIR%\gradlew.bat" (
  echo AS-Academy-Core Gradle wrapper not found at: %ACADEMY_CORE_DIR%
  exit /b 2
)

rem پوشه assets در Clone تازه ایجاد می‌شود.
if not exist "%BASIC_DIR%\app\src\main\assets" mkdir "%BASIC_DIR%\app\src\main\assets"

rem ابتدا Contract دوره Validate می‌شود.
call "%ACADEMY_CORE_DIR%\gradlew.bat" -p "%ACADEMY_CORE_DIR%" :tools:run --args="validate \"%BASIC_DIR%\course\basic\"" --stacktrace
if errorlevel 1 exit /b %errorlevel%

rem پس از Validation موفق، Bundle واحد مورد استفاده Android ساخته می‌شود.
call "%ACADEMY_CORE_DIR%\gradlew.bat" -p "%ACADEMY_CORE_DIR%" :tools:run --args="compile \"%BASIC_DIR%\course\basic\" \"%OUTPUT_FILE%\"" --stacktrace
if errorlevel 1 exit /b %errorlevel%

rem پیام نهایی مسیر فایل تولیدشده را نمایش می‌دهد.
echo Basic Course Bundle ready: %OUTPUT_FILE%
endlocal
