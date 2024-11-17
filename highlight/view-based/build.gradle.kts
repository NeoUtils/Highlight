@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
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
    }
}

android {
    namespace = config.module(name = "view")
}

dependencies {
    api(project(":highlight:core"))
    implementation(libs.androidx.appcompat)
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-view"
    )

    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = true,
            publishJavadocJar = false,
        )
    )

    pom {
        name.set("Highlight for View")
        description.set("View-based patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}