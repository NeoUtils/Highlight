import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.mavenPublish)
}

group = "highlight"

android {
    namespace = "com.neoutils.highlight.view"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    api(project(":highlight:core"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
}

mavenPublishing {
    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = false,
            publishJavadocJar = false,
        )
    )

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    coordinates(
        groupId = "com.neoutils.highlight",
        artifactId = "highlight-view",
        version = "2.0.0"
    )

    pom {
        name.set("Highlight for View")
        description.set("Pattern highlighter for view-based.")
        inceptionYear.set("2021")
        url.set("https://github.com/NeoUtils/Highlight")

        licenses {
            license {
                name.set("The MIT License")
                url.set("https://opensource.org/licenses/MIT")
            }
        }

        developers {
            developer {
                id.set("irineu333")
                name.set("Irineu A. Silva")
                url.set("https://github.com/Irineu333")
            }
        }

        scm {
            url.set("https://github.com/NeoUtils/Highlight")
            connection.set("scm:git:git://github.com/NeoUtils/Highlight.git")
            developerConnection.set("scm:git:ssh://git@github.com/NeoUtils/Highlight.git")
        }
    }

    signAllPublications()
}