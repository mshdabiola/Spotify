plugins {
    id ("mshdabiola.android.feature")
}

android {
    namespace = "com.mshdabiola.mainscreen"
    buildTypes {
        create("benchmark") {
            matchingFallbacks += listOf("release")
        }
    }
}

dependencies{
//    implementation(project(":core:ui"))
    implementation ("com.spotify.android:auth:1.2.5")
}