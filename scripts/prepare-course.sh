#!/usr/bin/env bash
# این Script منبع JSON قابل ویرایش Basic را با ابزار رسمی Core Validate و سپس Compile می‌کند.
set -euo pipefail

# محل Repository Basic مستقل از Current Working Directory محاسبه می‌شود.
BASIC_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
# در حالت عادی Core کنار Basic قرار دارد؛ CI یا کاربر می‌تواند مسیر را با Environment Variable تغییر دهد.
CORE_DIR="${ACADEMY_CORE_DIR:-${BASIC_DIR}/../AS-Academy-Core}"
# Bundle تولیدشده همان Assetای است که Android Loader در Runtime می‌خواند.
OUTPUT_FILE="${BASIC_DIR}/app/src/main/assets/basic-course.json"

# نبود Core خطای واضح می‌دهد تا Build با Course قدیمی ادامه پیدا نکند.
if [[ ! -x "${CORE_DIR}/gradlew" ]]; then
  echo "AS-Academy-Core Gradle wrapper not found at: ${CORE_DIR}" >&2
  exit 2
fi

# پوشه assets در Clone تازه ممکن است فقط .gitkeep داشته باشد؛ ایجاد مجدد امن است.
mkdir -p "$(dirname "${OUTPUT_FILE}")"

# Validator قبل از Compile تمام Stable IDها، Referenceها و Contract را بررسی می‌کند.
"${CORE_DIR}/gradlew" -p "${CORE_DIR}" :tools:run --args="validate \"${BASIC_DIR}/course/basic\"" --stacktrace
# Compiler فقط پس از Validation موفق Bundle نهایی را برای Android تولید می‌کند.
"${CORE_DIR}/gradlew" -p "${CORE_DIR}" :tools:run --args="compile \"${BASIC_DIR}/course/basic\" \"${OUTPUT_FILE}\"" --stacktrace

# مسیر خروجی برای استفاده مستقیم توسعه‌دهنده چاپ می‌شود.
echo "Basic Course Bundle ready: ${OUTPUT_FILE}"
