pluginManagement {
    repositories {
        includeBuild("build-logic")
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Spotify"
include(":app")
include(":benchmark")
include(":core:designsystem")
include(":core:model")
include(":feature:mainscreen")
include(":core:network")
include(":core:datastore")
include(":core:data")
include(":core:common")
include(":core:testing")
include(":core:ui")
include(":feature:libraryscreen")
include(":feature:searchscreen")
include(":feature:detailscreen")
