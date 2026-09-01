# AS Academy Basic 1.1.0-rc2 Release Gate

این سند Gateهای Release Candidate دوم خط 1.1 را ثبت می‌کند. RC2 قابلیت Runtime Content Update مستقل از APK را اضافه می‌کند و Stable `1.1.0` تا عبور Gateهای نصب واقعی منتشر نمی‌شود.

## Identity

- applicationId: `com.asdevelopers.academy.basic`
- versionCode: `11`
- versionName: `1.1.0-rc2`
- previous stable: `1.0.0` / versionCode `9`
- previous candidate: `1.1.0-rc1` / versionCode `10`
- signing identity: همان JKS خصوصی و پایدار نسخه `1.0.0`

## Frozen cross-repository inputs

- Core 1.4.0: `d8b42beb42894452d9420b8bf3200847c6294fb9`
- MainUi 0.1.0: `2519f76a1391e87dfbf784eb7c3b18c06868680b`
- MainCourse: `6169fa7464be3db213c2e7e29c03cabd297a555b`
- MainCourse Basic manifest: `version=1.1.0`, `curriculumVersion=1.1.0`, `minimumCoreVersion=1.3.0`

## Runtime content channel evidence

- [x] MainCourse remains the only editable Basic content source.
- [x] Core 1.4.0 runtime updater merged after full Core CI.
- [x] MainCourse Basic content workflow validates the canonical source.
- [x] MainCourse Basic content workflow compiles `basic-course.json`.
- [x] `latest.json` is generated from Course manifest data.
- [x] SHA-256 is generated and verified against the compiled package before publication.
- [x] Rolling public release `basic-content` exists.
- [x] Release contains `basic-course.json`, `basic-course.json.sha256` and `latest.json`.
- [x] Current package SHA-256: `cfed3c452dbe2efc803e9f31de9f462467a1040bbb05688dcf00bc9ef2ca0e22`.
- [x] Current package size: `1,553,478` bytes.

## Runtime safety gates implemented in Core

- [x] HTTPS-only metadata/package channel.
- [x] Redirects remain HTTPS-only and are bounded.
- [x] Metadata SemVer/`minimumCoreVersion` preflight before large Package download.
- [x] Current/downgrade/Core-incompatible releases are rejected before Package transfer.
- [x] SHA-256 validation before activation.
- [x] Course Validator before activation.
- [x] `courseId` match requirement.
- [x] SemVer update/downgrade policy is repeated against the decoded Package manifest.
- [x] `minimumCoreVersion` compatibility is repeated against the decoded Package manifest.
- [x] Atomic installation.
- [x] Backup/Rollback support.
- [x] Bundled APK asset and installed Runtime Package are both validated locally.
- [x] Installed Runtime Package is selected only when strictly newer than bundled APK content.
- [x] Equal/newer bundled APK content supersedes an older/equal installed Runtime Package.
- [x] Corrupt/mismatched/superseded installed Package is quarantined.
- [x] Valid installed content is retained if the bundled APK asset is invalid.

## Basic host integration

- [x] `BasicRuntimeContentApp` resolves local content before starting the normal Course Host.
- [x] Local content becomes usable before network update check.
- [x] Successful content install activates the installed Package and reloads `BasicAcademyApp`.
- [x] Network/update failure leaves current content active.
- [x] `INTERNET` permission added; no public storage permission required.
- [x] Android version raised to `versionCode=11 / versionName=1.1.0-rc2`.
- [x] Room/DataStore identity and package/applicationId remain unchanged.

## Automated APK gates

- [ ] Final RC2 four-repository CI completes successfully on the exact RC2 head.
- [ ] Canonical MainCourse Basic validation passes in Basic CI.
- [ ] MainCourse package compile into bundled Android asset passes.
- [ ] MainUi lint/build passes.
- [ ] Basic lintDebug/assembleDebug passes.
- [ ] Basic assembleRelease unsigned passes.
- [ ] Debug and unsigned Release SHA-256 artifacts generated.

این موارد پس از CI نهایی RC2 علامت‌گذاری می‌شوند.

## Device/Publish gates

- [ ] Build Signed RC2 with the exact same private JKS used for Stable 1.0.0 using Android APK signing.
- [ ] Verify signed RC2 certificate matches Stable 1.0.0.
- [ ] Independently verify package/version: `com.asdevelopers.academy.basic`, versionCode `11`.
- [ ] Install signed Stable 1.0.0 and create local progress/settings/draft data.
- [ ] Upgrade directly to signed RC2 without uninstalling.
- [ ] Confirm all local data is preserved.
- [ ] Smoke test Home, Drawer, Catalog, Lesson, Quiz, Exercise, Project, Placement, Weak Topic Review and Flashcard Review.
- [ ] Verify bundled MainCourse content works with network disabled.
- [ ] Verify Runtime Content metadata/channel is reachable on a real Android installation.
- [ ] Verify a newer test Course version can be installed and rendered without APK replacement.
- [ ] Verify bad/unreachable update channel falls back without blocking learning content.
- [ ] Verify APK update with equal/newer bundled Course does not regress to an older Runtime Package while offline.
- [ ] Record final Publish APK SHA-256 and Android signature verification evidence.

Stable `1.1.0` must not be tagged or published until all Device/Publish gates pass.
