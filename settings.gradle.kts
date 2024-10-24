@file:Suppress("UnstableApiUsage")

include(":highlight:view-based")
include(":highlight:compose")
include(":highlight:core")

include(":example:view-based")
include(":example:compose")

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
