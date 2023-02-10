package com.mshdabiola.spotify.navigation

import androidx.compose.foundation.layout.Spacer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mshdabiola.detailscreen.detailScreen
import com.mshdabiola.detailscreen.navigateToDetail
import com.mshdabiola.libraryscreen.libraryScreen
import com.mshdabiola.mainscreen.mainNavigationRoute
import com.mshdabiola.mainscreen.mainScreen
import com.mshdabiola.searchscreen.searchScreen

@Composable
fun SpotifyAppNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String = mainNavigationRoute,
) {
    NavHost(modifier=modifier,navController = navController, startDestination = startDestination) {
        mainScreen(
            onNavigateToDetail = navController::navigateToDetail
        )
        searchScreen( onNavigateToDetail = navController::navigateToDetail)
        libraryScreen ( onNavigateToDetail = navController::navigateToDetail)
        detailScreen { navController.popBackStack() }


    }
}
