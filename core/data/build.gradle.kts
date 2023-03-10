plugins {
    id("mshdabiola.android.library")
    id("mshdabiola.android.hilt")
}

android {
    namespace = "com.mshdabiola.data"
}
dependencies {
    implementation(project(":core:model"))

    implementation(project(":core:datastore"))
    implementation(project(":core:network"))
    testImplementation(project(":core:testing"))
}