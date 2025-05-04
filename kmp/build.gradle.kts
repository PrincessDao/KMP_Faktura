import com.android.build.gradle.internal.scope.publishBuildArtifacts
import org.jetbrains.kotlin.gradle.DeprecatedTargetPresetApi
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.InternalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.jetbrains.kotlin.gradle.plugin.mpp.apple.XCFramework
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kmmbridge)
    id("maven-publish")
}

repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

val secretsFile: Path = Paths.get(rootProject.rootDir.absolutePath, "secrets.json")
val secretsJson = String(Files.readAllBytes(secretsFile))
val jsonObject: JsonObject = JsonParser.parseString(secretsJson).asJsonObject
val githubToken: String = jsonObject.get("githubToken").asString

kotlin {
    val osName = System.getProperty("os.name")
    val targetOs = when {
        osName == "Mac OS X" -> "macos"
        osName.startsWith("Win") -> "windows"
        osName.startsWith("Linux") -> "linux"
        else -> error("Unsupported OS: $osName")
    }

    val osArch = System.getProperty("os.arch")
    val targetArch = when (osArch) {
        "x86_64", "amd64" -> "x64"
        "aarch64" -> "arm64"
        else -> error("Unsupported arch: $osArch")
    }

    val versionSkiko = "0.9.16"
    val target = "${targetOs}-${targetArch}"


    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
        publishLibraryVariants("release")
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "KMPLibrary"
            export("org.jetbrains.skiko:skiko")
            freeCompilerArgs += listOf("-g")
        }
    }

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
                implementation("org.jetbrains.skiko:skiko:0.9.16")
            }
        }
        val iosMain by creating {
            dependsOn(commonMain)
            dependencies {

            }
        }

        iosX64Main { dependsOn(iosMain) }
        iosArm64Main { dependsOn(iosMain) }
        iosSimulatorArm64Main { dependsOn(iosMain) }
    }
}

android {
    namespace = "com.example.kmp"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

version = "0.0.1"
group = "com.example"

addGithubPackagesRepository()
kmmbridge {
    mavenPublishArtifacts()
    spm()
}