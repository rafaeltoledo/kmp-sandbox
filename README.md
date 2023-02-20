# KMP Sandbox

A sandbox project to explore Kotlin Multiplatform.

![Build](https://github.com/rafaeltoledo/kmp-sandbox/workflows/build/badge.svg)

This is not intended to be a guide or anything related. I'm just trying to explore what's possible, the current state of the framework/tools, etc. But I'll do my explorations here in an open way, so it may be useful to other people.

## Initial Goals

- [x] To have a buildable empty project on Android and iOS with a single shared module
- [x] Add `shared` module as dependency on both Android and iOS apps
- [x] To have an empty screen (Compose-based on Android, SwiftUI-based on iOS) consuming a single method from the shared module
- [ ] Configure Github Actions to make APK available to download
- [ ] Setup [Kotlin Multiplatform Serialization](https://github.com/Kotlin/kotlinx.serialization) on the `shared`
- [ ] Setup [Ktor](https://ktor.io/) client on the `shared` module, and its JSON support using **KMS**
- [ ] Create a [Reddit](https://www.reddit.com/dev/api/) Application to be used with this project and setup the secrets on Github Actions
- [ ] Create a `/r/frontpage/hot` mockup on Android (with static data, text only)
- [ ] Craate a `/r/frontpage/hot` mockup on iOS (with static data, text only)
- [ ] Map basic endpoints / data models from Reddit API in the `shared` module
- [ ] millions of intermediate steps
- [ ] A working client for the Reddit API. Why Reddit? Because I find their API a bit too much complex. So it would be a good exercise to consume it in a clean way.
