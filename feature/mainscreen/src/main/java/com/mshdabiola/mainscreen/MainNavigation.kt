package com.mshdabiola.mainscreen

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val mainNavigationRoute = "main_route"

const val mainRoute = "main_route"

fun NavGraphBuilder.mainScreen(
    onNavigateToDetail : (String,String)->Unit={_,_->}
) {
    composable(
        route = mainRoute,
    ) {
        MainScreen(onNavigateToDetail = onNavigateToDetail)
    }
}

fun NavController.navigateToMain(navOption: NavOptions) {
    navigate(route = mainRoute,navOptions = navOption)
}
