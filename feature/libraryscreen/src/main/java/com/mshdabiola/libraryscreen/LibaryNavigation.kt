package com.mshdabiola.libraryscreen


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val libraryRoute = "library_route"

fun NavGraphBuilder.libraryScreen(onBack: () -> Unit) {
    composable(
        route = libraryRoute
    ) {
        LibraryScreen(onBack = onBack)
    }
}

fun NavController.navigateToLibrary(navOption: NavOptions) {
    navigate(route = libraryRoute, navOptions = navOption)
}
