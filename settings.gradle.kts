@file:Suppress("UnstableApiUsage")

include(":example:compose")


include(":highlight:view-based")
include(":highlight:compose")
include(":highlight:core")
include(":example:view-based")

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
