# Paper Language Kotlin

Adds Kotlin language support to your Paper Server.

## Included Kotlin Libraries

### Kotlin core
- kotlin-stdlib
- kotlin-reflect

### KotlinX
- kotlinx-coroutines-core
- kotlinx-coroutines-jdk8
- kotlinx-serialization-core
- kotlinx-serialization-json
- kotlinx-serialization-cbor
- kotlinx-datetime
- kotlinx-io-core
- kotlinx-io-bytestring
- atomicfu

---
## Setup
1. Download the Plugin from [Releases](https://repo.xxjanisxx.dev/#/releases/dev/xxjanisxx/paper-language-kotlin)
2. Place the Jar in your `plugins/` folder
3. Restart your server
---

## Usage
Add this to your `paper-plugin.yml`:

```yaml
dependencies:
  server:
    paper-language-kotlin:
      load: BEFORE
      required: true
      join-classpath: true
```