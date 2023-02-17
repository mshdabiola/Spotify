@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("mshdabiola.android.application")
    id("mshdabiola.android.application.compose")
    id("mshdabiola.android.hilt")
    //alias(libs.plugins.google.services)
    // alias(libs.plugins.firebase.crashlytics)

}

android {
    namespace = "com.mshdabiola.spotify"

    defaultConfig {
        applicationId = "com.mshdabiola.spotify"
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-debug"
        }
        val release by getting {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            // Todo: comment code before release
//            signingConfig = signingConfigs.getByName("debug")
        }
        val benchmark by creating {
            // Enable all the optimizations from release build through initWith(release).
            initWith(release)
            matchingFallbacks += listOf("release")
            // Debug key signing is available to everyone.
            signingConfig = signingConfigs.getByName("debug")
            // Only use benchmark proguard rules
            proguardFiles("benchmark-rules.pro")
            //  FIXME enabling minification breaks access to demo backend.
            isMinifyEnabled = false
            applicationIdSuffix = ".benchmark"
            versionNameSuffix = "-benchmark"
        }
    }


    packagingOptions {
        excludes += "/META-INF/AL2.0"
        excludes += "/META-INF/LGPL2.1"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    //implementation(libs.bundles.compose.bundle)
    implementation(project(":core:designsystem"))
    implementation(project(":feature:mainscreen"))
    implementation(project(":feature:searchscreen"))
    implementation(project(":feature:libraryscreen"))
    implementation(project(":feature:detailscreen"))
    implementation(project(":core:common"))
    implementation(project(":core:ui"))
    implementation(libs.androidx.profileinstaller)
    //implementation(libs.kotlinx.collection.immutable)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.timber)
    implementation(libs.androidx.compose.material.iconsExtended)
//    implementation(libs.firebase.crashlytics.kts)
//    implementation(libs.firebase.analytics.kts)

    //testImplementation (libs.junit4)
    //androidTestImplementation (libs.bundles.android.test.bundle)
    //debugImplementation (libs.bundles.compose.debug.bundle)

    // For media playback using ExoPlayer
    implementation(libs.androidx.media3.exoplayer)
    // For exposing and controlling media sessions
    implementation(libs.androidx.media3.session)
    implementation(libs.auth)
    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.kotlinx.collection.immutable)

}