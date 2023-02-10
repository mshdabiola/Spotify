plugins {
    id ("mshdabiola.android.feature")
}

android {
    namespace = "com.mshdabiola.detailscreen"
    buildTypes {
        create("benchmark") {
            matchingFallbacks += listOf("release")
        }
    }
}