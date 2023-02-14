package com.mshdabiola.spotify.navigation

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
import com.mshdabiola.ui.data.TrackUiState

@Composable
fun SpotifyAppNavHost(
    modifier: Modifier,
    showNavBar: (Boolean) -> Unit = {},
    navController: NavHostController,
    startDestination: String = mainNavigationRoute,
    onMediaItems: (List<TrackUiState>) -> Unit = {},

    ) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        mainScreen(
            onNavigateToDetail = navController::navigateToDetail,
            showNavBar = showNavBar
        )
        searchScreen(onNavigateToDetail = navController::navigateToDetail)
        libraryScreen(onNavigateToDetail = navController::navigateToDetail)
        detailScreen(onBack = { navController.popBackStack() }, onMediaItems)
    }
}
