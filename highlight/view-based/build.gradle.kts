@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import extension.config
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.neoutils.android.library)
}

kotlin {
    sourceSets {
        androidTarget {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_1_8)
            }
        }

        commonMain.dependencies {
            api(project(":highlight:core"))
        }

        androidMain.dependencies {
            implementation(libs.androidx.appcompat)
        }
    }
}

android {
    namespace = config.module(name = "view")
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-view"
    )

    pom {
        name.set("Highlight for View")
        description.set("View-based patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}