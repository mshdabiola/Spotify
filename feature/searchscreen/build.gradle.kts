plugins {
    id ("mshdabiola.android.feature")
}

android {
    namespace = "com.mshdabiola.searchscreen"
    buildTypes {
        create("benchmark") {
            matchingFallbacks += listOf("release")
        }
    }
}