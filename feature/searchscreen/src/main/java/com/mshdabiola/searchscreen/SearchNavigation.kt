package com.mshdabiola.searchscreen


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val searchRoute = "search_route"

fun NavGraphBuilder.searchScreen(onBack: () -> Unit) {
    composable(
        route = searchRoute
    ) {
        SearchScreen(onBack = onBack)
    }
}

fun NavController.navigateToSearch(navOption: NavOptions) {
    navigate(route = searchRoute, navOptions = navOption)
}
