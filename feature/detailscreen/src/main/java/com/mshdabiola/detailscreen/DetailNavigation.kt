package com.mshdabiola.detailscreen


import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val detailRoute = "detail_route"

fun NavGraphBuilder.detailScreen(onBack: () -> Unit) {
    composable(
        route = detailRoute
    ) {
        DetailScreen(onBack = onBack)
    }
}

fun NavController.navigateToDetail() {
    navigate(route = detailRoute)
}
