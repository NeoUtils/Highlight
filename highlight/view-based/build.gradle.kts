import extension.config

plugins {
    alias(libs.plugins.neoutils.android.library)
}

android {
    namespace = config.module(name = "view")
}

dependencies {

    api(project(":highlight:core"))

    implementation(libs.androidx.appcompat) {
        because("view-based utilities")
    }
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