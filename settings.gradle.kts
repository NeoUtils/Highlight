@file:Suppress("UnstableApiUsage")

include(":example:view-based")
include(":highlight:view-based")
include(":highlight:core")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Highlight"
