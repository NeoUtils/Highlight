import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost
import extension.config

plugins {
    id("com.vanniktech.maven.publish")
    id("com.android.library")
    kotlin("android")
}

group = config.group
version = config.version

android {
    compileSdk = config.android.compileSdk

    defaultConfig {
        minSdk = config.android.minSdk
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

mavenPublishing {
    configure(
        AndroidSingleVariantLibrary(
            variant = "release",
            sourcesJar = true,
            publishJavadocJar = false,
        )
    )

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

    pom {
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
