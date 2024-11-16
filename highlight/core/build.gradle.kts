import extension.config

plugins {
    alias(libs.plugins.neoutils.android.library)
}

android {
    namespace = config.module(name = "core")
}

dependencies {

    implementation(libs.androidx.core.ktx) {
        because("utilities")
    }
}

mavenPublishing {

    coordinates(
        artifactId = "highlight-core"
    )

    pom {
        name.set("Highlight")
        description.set("Patterned highlighting.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")
    }
}