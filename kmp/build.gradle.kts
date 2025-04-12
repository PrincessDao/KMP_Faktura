import org.jetbrains.kotlin.gradle.DeprecatedTargetPresetApi
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.InternalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.androidLibrary)
    id("maven-publish")
}

val secretsFile: Path = Paths.get(rootProject.rootDir.absolutePath, "secrets.json")
val secretsJson = String(Files.readAllBytes(secretsFile))
val jsonObject: JsonObject = JsonParser.parseString(secretsJson).asJsonObject
val githubToken: String = jsonObject.get("githubToken").asString

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
        publishLibraryVariants("release", "debug")
    }
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime.ktx)
                implementation(libs.androidx.activity.compose)
            }
        }
        val commonMain by getting {
            dependencies {
                implementation(kotlin("stdlib-common"))
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(compose.material3)
                implementation(libs.navigation.compose)
                implementation(libs.resources)
                implementation(libs.resourcesCompose)
            }
        }
    }
}

android {
    namespace = "com.example.kmp.library"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

group = "com.example"
version = "1.0.0"

publishing {
    publications {
        withType<MavenPublication> {
            artifactId = "kmp-library"

            pom {
                name.set("KMP Library")
                description.set("A multiplatform library for KMP projects")
                url.set("https://github.com/PrincessDao/KMP_Faktura")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("129617886")
                        name.set("PrincessDao")
                        email.set("grprincessdao@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:git://github.com/PrincessDao/KMP_Faktura.git")
                    developerConnection.set("scm:git:ssh://github.com/PrincessDao/KMP_Faktura.git")
                    url.set("https://github.com/PrincessDao/KMP_Faktura")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/PrincessDao/KMP_Faktura")
            credentials {
                username = project.findProperty("GITHUB_USERNAME") as String? ?: System.getenv("GITHUB_USERNAME")
                password = githubToken
            }
        }
    }
}