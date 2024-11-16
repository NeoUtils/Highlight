@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
    }
}

include(
    ":highlight:view-based",
    ":highlight:compose",
    ":highlight:core"
)

include(
    ":example:view-based",
    ":example:compose"
)

rootProject.name = "Highlight"
