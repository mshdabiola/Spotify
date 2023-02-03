plugins {
    id("mshdabiola.android.library")
    id ("mshdabiola.android.library.compose")
}

android {
    namespace = "com.mshdabiola.ui"
}
dependencies{

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(project(":core:model"))

}