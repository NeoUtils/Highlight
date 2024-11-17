@file:OptIn(ExperimentalKotlinGradlePluginApi::class)

import com.vanniktech.maven.publish.KotlinMultiplatform
import extension.config
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.neoutils.android.library)
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
            implementation(libs.androidx.annotation)
        }
    }
}

android {
    namespace = config.module(name = "core")
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-core"
    )

    configure(
        KotlinMultiplatform(
            sourcesJar = true,
            androidVariantsToPublish = listOf("release"),
        )
    )

    pom {
        name.set("Highlight")
        description.set("Patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}