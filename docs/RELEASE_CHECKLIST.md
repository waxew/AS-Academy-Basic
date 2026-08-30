# Basic 1.0.0 Release Checklist

این سند وضعیت نهایی نخستین نسخه Stable دوره Basic را ثبت می‌کند.

## Version and identity

- [x] `applicationId = com.asdevelopers.academy.basic` ثابت است.
- [x] `versionCode = 9` و از نسخه قبل بزرگ‌تر است.
- [x] `versionName = 1.0.0` است.
- [x] Course manifest و Curriculum هر دو `1.0.0` هستند.
- [x] `minimumCoreVersion = 1.2.0` با API مصرف‌شده Host منطبق است.
- [x] Stable IDهای منتشرشده تغییر نکرده‌اند.

## Course completeness

- [x] 4 سطح اصلی.
- [x] 39 فصل.
- [x] 157 درس واقعی.
- [x] 73 Quiz / 534 سؤال.
- [x] 195 Exercise.
- [x] 40 Challenge Exercise.
- [x] 14 Project.
- [x] 69 Glossary entry.
- [x] Placement، Depth Assessment، Micro Quiz و Interview Bank وجود دارند.
- [x] Final Capstone وجود دارد.

## Runtime and learning quality

- [x] Lesson / Quiz / Exercise / Project به UI مشترک Core وصل هستند.
- [x] Quiz history در Room ذخیره می‌شود.
- [x] Placement result قابل بازیابی است.
- [x] Weak Topic Review از history واقعی استفاده می‌کند.
- [x] Flashcard/Spaced Review persistence فعال است.
- [x] Exercise draft/completion و Project progress پایدارند.
- [x] Settings/Profile/Drawer/RTL/Back navigation از Core مصرف می‌شوند.
- [x] داده کاربر با تغییر Content Version بازنویسی مخرب نمی‌شود.

## Automated QA

- [x] Course Validator سبز.
- [x] Course Compiler سبز.
- [x] Android Lint سبز.
- [x] Debug APK build سبز.
- [x] Release variant build سبز.
- [x] SHA-256 برای خروجی‌ها تولید و مستقل تطبیق داده شد.

## Publish signing

- [x] یک keystore خصوصی و پایدار برای `com.asdevelopers.academy.basic` ساخته شده است.
- [x] keystore داخل repository عمومی Commit نشده است.
- [x] Release APK با همان keystore امضا شده است.
- [x] `apksigner verify --verbose --print-certs` موفق است.
- [x] SHA-256 فایل Publish ثبت شده است: `00abcd81578227ff2b4aca6d3055e35e922c50063fff00f516ca49772c648959`.
- [x] fingerprint گواهی Signing ثبت شده است: `611be8ffff16978f90ff3ffec761500af4da78379bb51f7299486acbf5822cba`.
- [x] Backup رمز‌شده Signing بازیابی آزمایشی شد و JKS بازیابی‌شده همان Certificate APK را دارد.

## Final delivery pack

- [x] APK Publish/Release نهایی: `AS-Academy-Basic-1.0.0.apk`.
- [x] APK Debug: `AS-Academy-Basic-1.0.0-debug.apk`.
- [x] Source ZIP کامل: `source.as-academy-basic-1.0.0.zip`.
- [x] `info.txt` و اطلاعات نسخه/Package/Signing certificate موجود است.
- [x] SHA-256/checksum خروجی‌ها موجود است.
- [x] گزارش verify امضای APK موجود است.
- [x] Backup خصوصی Signing برای نگهداری و Updateهای بعدی آماده است.
- [x] GitHub Release `v1.0.0` روی commit `e12f885c59582964e7a53ccfc3333504b9a1b2f2` منتشر شده است.

## نتیجه

**AS Academy Basic 1.0.0 Released / Production-ready baseline.**

تمام APKهای بعدی با package `com.asdevelopers.academy.basic` باید با همین keystore نسخه 1.0.0 امضا شوند تا نصب Update بدون حذف برنامه و داده‌های کاربر ممکن بماند.
