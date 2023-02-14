plugins {
    id("mshdabiola.android.feature")
}

android {
    namespace = "com.mshdabiola.libraryscreen"
    buildTypes {
        create("benchmark") {
            matchingFallbacks += listOf("release")
        }
    }
}