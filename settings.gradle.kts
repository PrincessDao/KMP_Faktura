rootProject.name = "KMP_Faktura"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    val osName = extra["osName"] as String

    val agpVersion = if (osName.contains("Mac", ignoreCase = true)) {
        "8.7.3"
    } else {
        "8.6.0"
    }

    plugins {
        id("com.android.application") version agpVersion
        id("com.android.library") version agpVersion
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":composeApp")