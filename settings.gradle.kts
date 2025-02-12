rootProject.name = "KMP_Faktura"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    val osName = System.getProperty("os.name")
    val agpVersion = when {
        osName.contains("Mac", ignoreCase = true) -> "8.7.3"
        osName.contains("Windows", ignoreCase = true) -> "8.6.0"
        else -> "8.6.0"
    }

    println("Operating System: $osName")
    println("AGP Version: $agpVersion")

    extra["agpVersion"] = agpVersion

    plugins {
        id("com.android.application") version agpVersion
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

include(":composeApp")
include(":kmp")
