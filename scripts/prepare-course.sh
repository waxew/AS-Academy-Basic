#!/usr/bin/env bash
# MainCourse is the canonical educational source; Core validates/compiles it into the Basic Android asset.
set -euo pipefail

BASIC_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
CORE_DIR="${ACADEMY_CORE_DIR:-${BASIC_DIR}/../AS-Academy-Core}"
MAIN_COURSE_DIR="${ACADEMY_MAIN_COURSE_DIR:-${BASIC_DIR}/../AS-Academy-MainCourse}"
COURSE_DIR="${MAIN_COURSE_DIR}/courses/basic/course"
OUTPUT_FILE="${BASIC_DIR}/app/src/main/assets/basic-course.json"

if [[ ! -x "${CORE_DIR}/gradlew" ]]; then
  echo "AS-Academy-Core Gradle wrapper not found at: ${CORE_DIR}" >&2
  exit 2
fi

# Failing instead of falling back to Basic/course/basic prevents two diverging sources of truth.
if [[ ! -f "${COURSE_DIR}/manifest.json" ]]; then
  echo "Canonical Basic Course Package not found at: ${COURSE_DIR}" >&2
  echo "Clone AS-Academy-MainCourse next to Basic or set ACADEMY_MAIN_COURSE_DIR." >&2
  exit 3
fi

mkdir -p "$(dirname "${OUTPUT_FILE}")"

"${CORE_DIR}/gradlew" -p "${CORE_DIR}" :tools:run --args="validate \"${COURSE_DIR}\"" --stacktrace
"${CORE_DIR}/gradlew" -p "${CORE_DIR}" :tools:run --args="compile \"${COURSE_DIR}\" \"${OUTPUT_FILE}\"" --stacktrace

echo "Basic Course Bundle ready from MainCourse: ${OUTPUT_FILE}"
