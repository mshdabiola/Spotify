package com.mshdabiola.libraryscreen


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val libraryRoute = "library_route"

fun NavGraphBuilder.libraryScreen(onNavigateToDetail: (String, String) -> Unit = { _, _ -> }) {
    composable(
        route = libraryRoute
    ) {
        LibraryScreen(onNavigateToDetail = onNavigateToDetail)
    }
}

fun NavController.navigateToLibrary(navOption: NavOptions) {
    navigate(route = libraryRoute, navOptions = navOption)
}
