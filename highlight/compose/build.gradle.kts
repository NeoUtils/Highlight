import extension.config

plugins {
    alias(libs.plugins.neoutils.android.library)
    alias(libs.plugins.compose.compiler)
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

dependencies {

    api(project(":highlight:core"))

    implementation(libs.androidx.runtime) {
        because("obviously")
    }

    implementation(libs.androidx.ui.text) {
        because("AnnotatedString, SpanStyle, TextFieldValue")
    }

    implementation(libs.androidx.ui.graphics) {
        because("Color")
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