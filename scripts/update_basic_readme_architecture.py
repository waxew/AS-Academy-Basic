from pathlib import Path


path = Path("README.md")
text = path.read_text(encoding="utf-8")

replacements = {
    "- Core: `AS-Academy-Core >= 1.2.0`\n- Course/Host: **1.0.0**\n- Android `versionCode`: **9**\n":
        "- Core runtime: `AS-Academy-Core 1.3.0`\n"
        "- Shared UI: `AS-Academy-MainUi 0.1.0`\n"
        "- Canonical content: `AS-Academy-MainCourse/courses/basic/course`\n"
        "- Stable release: **1.0.0**\n"
        "- Current migration line: **1.1.0-dev**\n"
        "- Android `versionCode`: **10**\n",
    "این Repository فقط Course Package، محتوای Basic، Branding و Host اختصاصی را نگه می‌دارد. Navigation، Drawer/Profile، Settings، Room، Progress، Quiz/Exercise/Project Engine و UI، Search، Bookmark، Notes، Backup/Restore، Lesson Renderer، Placement، Weak Topic Review و Spaced Review در `AS-Academy-Core` هستند و در Basic تکرار نمی‌شوند.\n":
        "این Repository از معماری جدید به بعد یک **Thin Course Host** است. محتوای آموزشی Basic فقط در `AS-Academy-MainCourse/courses/basic/course` نگهداری می‌شود؛ Presentation مشترک شامل Theme، AppShell، Home، Catalog، Lesson، Quiz، Exercise، Project، Settings و Reviewها از `AS-Academy-MainUi` مصرف می‌شود؛ Engine، Navigation contract، Room، Progress، Quiz/Exercise/Project logic، Placement، Weak Topic Review و Spaced Review در `AS-Academy-Core` باقی می‌مانند. پوشه `course/basic` در این Repository فقط Snapshot تاریخی 1.0.0 است و منبع ویرایش محتوای جدید نیست.\n",
    "- Lesson/Quiz/Exercise/Project از UI مشترک Core استفاده می‌کنند.\n- Placement Summary، Weak Topic Review و Flashcard Review فعال‌اند.\n":
        "- Theme/AppShell/Home/Catalog و Lesson/Quiz/Exercise/Project/Settings/Review از facade مشترک MainUi استفاده می‌کنند.\n"
        "- Placement Summary، Weak Topic Review و Flashcard Review فعال‌اند و Presentation آن‌ها از MainUi عبور می‌کند.\n",
    "- Course Package قبل Build با Validator/Compiler رسمی Core بررسی می‌شود.\n- GitHub Actions: `Validate -> Compile -> Lint -> Assemble Debug -> Assemble Release -> SHA-256 -> Upload QA Artifacts`.\n- `versionCode=9 / versionName=1.0.0` برای Update سالم روی نسخه‌های قبلی.\n":
        "- Course Package از MainCourse دریافت و قبل Build با Validator/Compiler رسمی Core بررسی می‌شود.\n"
        "- GitHub Actions: `Checkout MainCourse/MainUi/Core -> Validate -> Compile -> MainUi Lint/Build -> Basic Lint/Debug -> Release -> SHA-256 -> QA Artifacts`.\n"
        "- خط توسعه فعلی `versionCode=10 / versionName=1.1.0-dev` است؛ package و signing identity نسخه 1.0.0 تغییر نکرده‌اند.\n",
    "## Version History\n\n### 1.0.0 — Stable Release\n":
        "## Version History\n\n"
        "### 1.1.0-dev — MainCourse/MainUi architecture migration\n\n"
        "- انتقال کامل Course Package دوره Basic به `AS-Academy-MainCourse/courses/basic/course`\n"
        "- تبدیل MainCourse به Single Source of Truth محتوای Basic\n"
        "- افزودن `AS-Academy-MainUi` به build واقعی Android\n"
        "- انتقال Theme، AppShell، Home، Learning Catalog و Screenهای مشترک پشت facade MainUi\n"
        "- ارتقا runtime به Core 1.3.0 و فعال‌سازی Learning Catalog\n"
        "- ارتقا Android به `versionCode=10 / versionName=1.1.0-dev` بدون تغییر package/signing identity\n"
        "- CI یکپارچه `MainCourse -> Core -> MainUi -> Basic`\n\n"
        "### 1.0.0 — Stable Release\n",
    "`Release Candidate 1.0.0 / Four-level curriculum covered / Adaptive learning active / 195 exercises / 534 questions / awaiting final signed publish artifact`":
        "`1.0.0 released / 1.1.0-dev architecture migration active / content source = MainCourse / presentation = MainUi / runtime = Core 1.3.0`",
}

for old, new in replacements.items():
    count = text.count(old)
    if count != 1:
        raise SystemExit(f"Expected one README match, got {count}: {old[:80]!r}")
    text = text.replace(old, new, 1)

build_marker = "## Build\n\nLinux/macOS:\n"
build_note = (
    "## Build\n\n"
    "چیدمان پیش‌فرض توسعه چهار Repository هم‌سطح است: `AS-Academy-Core/`، `AS-Academy-MainUi/`، "
    "`AS-Academy-MainCourse/` و `AS-Academy-Basic/`. اسکریپت prepare-course فقط محتوای canonical MainCourse را Compile می‌کند و عمداً به Snapshot محلی fallback نمی‌کند.\n\n"
    "Linux/macOS:\n"
)
if text.count(build_marker) != 1:
    raise SystemExit("Build section marker not found exactly once")
text = text.replace(build_marker, build_note, 1)

path.write_text(text, encoding="utf-8")
print("README updated for MainCourse/MainUi architecture")
