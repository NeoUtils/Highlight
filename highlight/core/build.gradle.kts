import com.vanniktech.maven.publish.KotlinMultiplatform
import extension.config

plugins {
    alias(libs.plugins.neoutils.android.library)
}

kotlin {
    jvm()

    js(IR) {
        browser()
        binaries.library()
    }

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