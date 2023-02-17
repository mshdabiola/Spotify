plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.hilt")
}

android {
    namespace = "com.mshdabiola.common"
    buildTypes {
        create("benchmark") {
            matchingFallbacks += listOf("release")
        }
    }
}
dependencies {
    testImplementation(project(":core:testing"))

    // For media playback using ExoPlayer
    implementation(libs.androidx.media3.exoplayer)
    // For exposing and controlling media sessions
    implementation(libs.androidx.media3.session)
}