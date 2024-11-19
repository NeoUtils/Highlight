import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import extension.config

plugins {
    alias(libs.plugins.neoutils.android.library)
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