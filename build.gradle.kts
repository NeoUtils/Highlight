plugins {
    // android
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.android.application) apply false

    // kotlin
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.js) apply false

    // compose
    alias(libs.plugins.compose.compiler) apply false
    alias(libs.plugins.jetbrains.compose) apply false

    // publish
    alias(libs.plugins.mavenPublish) apply false
}
