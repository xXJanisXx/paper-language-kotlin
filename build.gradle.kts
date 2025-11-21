import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.1.10"
    id("maven-publish")
}

group = "dev.xxjanisxx"
version = "0.0.1"
description = "Adds Kotlin language support to Paper including Kotlin Runtime, coroutines, serialization, atomicfu-jvm, datetime, io-core and io-bytestring."

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
}

kotlin {
    jvmToolchain(21)
}

tasks {
    compileJava {
        options.release.set(21)
        options.encoding = "UTF-8"
    }

    compileKotlin {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_21)
    }
}

publishing {
    repositories {
        maven("https://repo.xxjanisxx.dev/releases") {
            credentials {
                username = (System.getenv("REPO_USERNAME") ?: project.findProperty("repoUserName")).toString()
                password = (System.getenv("REPO_PASSWORD") ?: project.findProperty("repoPassword")).toString()
            }
        }
    }

    publications {
        create<MavenPublication>(project.name) {
            from(components["java"])

            this.groupId = project.group.toString()
            this.artifactId = project.name.lowercase()
            this.version = project.version.toString()

            pom {
                name.set(project.name)
                description.set(project.description)

                developers {
                    developer {
                        name.set("xXJanisXx")
                        url.set("https://xxjanisxx.dev")
                    }
                }

                licenses {
                    license {
                        name.set("MIT")
                        url.set("https://opensource.org/license/mit")
                    }
                }

                url.set("https://github.com/xXJanisXx/paper-language-kotlin")

                scm {
                    connection.set("scm:git:git://github.com/xXJanisXx/paper-language-kotlin.git")
                    url.set("https://github.com/xXJanisXx/paper-language-kotlin/tree/main")
                }
            }
        }
    }
}