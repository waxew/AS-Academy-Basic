# Basic 1.0.0 Release Checklist

این سند معیار نهایی انتشار نخستین نسخه Stable دوره Basic است.

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

- [ ] Course Validator سبز.
- [ ] Course Compiler سبز.
- [ ] Android Lint سبز.
- [ ] Debug APK build سبز.
- [ ] Release variant build سبز.
- [ ] SHA-256 برای Debug و Release QA تولید شده است.

## Publish signing

- [ ] یک keystore خصوصی و پایدار برای `com.asdevelopers.academy.basic` ساخته شده است.
- [ ] keystore داخل repository عمومی Commit نشده است.
- [ ] Release APK با همان keystore امضا شده است.
- [ ] `apksigner verify --verbose --print-certs` موفق است.
- [ ] SHA-256 فایل Publish ثبت شده است.
- [ ] fingerprint گواهی Signing ثبت شده است.

## Final delivery pack

- [ ] APK Publish/Release نهایی با نام بدون `debug`.
- [ ] APK Debug.
- [ ] Source ZIP کامل.
- [ ] `info.txt` شامل Version، Package، Signing certificate fingerprint و دستورهای Build/Verify.
- [ ] SHA-256/checksum خروجی‌ها.
- [ ] گزارش verify امضای APK.

تا زمانی که تمام موارد Automated QA و Publish signing سبز نشده‌اند، نسخه `1.0.0` فقط Release Candidate محسوب می‌شود.
