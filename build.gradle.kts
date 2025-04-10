plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    id("dev.icerock.mobile.multiplatform-resources") version "0.24.5"
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
