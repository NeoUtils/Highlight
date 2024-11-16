plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

group = "example"

android {
    namespace = "com.neoutils.highlight.example.view"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.neoutils.highlight.example.view"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":highlight:view-based"))

    implementation(libs.androidx.core.ktx)

    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.activity)
    implementation(libs.material)
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