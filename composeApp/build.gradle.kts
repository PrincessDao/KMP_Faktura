import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

val secretsFile: Path = Paths.get(rootProject.rootDir.absolutePath, "secrets.json")
val secretsJson = String(Files.readAllBytes(secretsFile))
val jsonObject: JsonObject = JsonParser.parseString(secretsJson).asJsonObject
val githubToken: String = jsonObject.get("githubToken").asString

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        @OptIn(ExperimentalKotlinGradlePluginApi::class)
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.androidx.lifecycle.runtime.ktx)
                implementation(compose.preview)
                implementation(libs.androidx.activity.compose)
                implementation(compose.components.uiToolingPreview)
                implementation(libs.androidx.navigation.compose)
                implementation(libs.androidx.lifecycle.viewmodel)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.accompanist.systemuicontroller.v0311alpha)
            }
        }
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.components.resources)
                implementation(compose.components.uiToolingPreview)
                implementation(compose.material3)
                implementation(libs.navigation.compose)
                //
            }
        }
        iosMain {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.ui)
            }
        }
    }
}

android {
    namespace = "org.example.kmp"
    compileSdk = 35
    defaultConfig {
        targetSdk = libs.versions.android.targetSdk.get().toInt()
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resource")

    defaultConfig {
        applicationId = "org.example.kmp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        compose = true
    }
    dependencies {
        debugImplementation(compose.uiTooling)
    }
}

dependencies {
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.ui)
    implementation(libs.material)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.ui.android)
    implementation(libs.androidx.core)
    implementation(libs.androidx.annotation.jvm)
    implementation(libs.gson)
}

repositories {
    maven {
        url = uri("https://maven.pkg.github.com/PrincessDao/KMP_Faktura")
        credentials {
            username = project.findProperty("GITHUB_USERNAME") as String? ?: System.getenv("GITHUB_USERNAME")
            password = githubToken
        }
    }
}