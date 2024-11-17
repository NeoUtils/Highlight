plugins {
    alias(libs.plugins.kotlin.js)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.compose.compiler)
}

group = "com.neoutils.highlight.example"
version = "1.0.0"

kotlin {
    js(IR) {

        moduleName = "app"

        browser {
            commonWebpackConfig {
                outputFileName = "app.js"
            }
        }

        binaries.executable()
    }
}

dependencies {

    implementation(project(":highlight:compose"))

    implementation(compose.runtime)
    implementation(compose.foundation)
    implementation(compose.ui)
    implementation(compose.material3)
}

repositories {

    google()
    mavenCentral()

    maven {
        url = uri("https://central.sonatype.com/api/v1/publisher/deployments/download/")

        credentials(HttpHeaderCredentials::class) {
            name = "Authorization"
            value = "Bearer ${findProperty("mavenCentralToken")}"
        }

        authentication {
            create<HttpHeaderAuthentication>("header")
        }
    }
}