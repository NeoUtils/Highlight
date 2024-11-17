@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(
    ":highlight:view-based",
    ":highlight:compose",
    ":highlight:core"
)

include(
    ":example:view-based",
    ":example:compose",
    ":example:desktop"
)

rootProject.name = "Highlight"
