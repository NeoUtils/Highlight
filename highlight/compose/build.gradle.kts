@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import extension.config
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.neoutils.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_1_8)
        }
    }

    jvm()

    sourceSets {
        commonMain.dependencies {
            api(project(":highlight:core"))

            implementation(compose.runtime) {
                because("remember extensions")
            }

            implementation(compose.ui) {
                because("AnnotatedString, SpanStyle, TextFieldValue, Color")
            }
        }
    }
}

android {
    namespace = config.module(name = "compose")

    defaultConfig {
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildFeatures {
        compose = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-compose",
    )

    pom {
        name.set("Highlight for Jetpack Compose")
        description.set("Jetpack Compose patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}