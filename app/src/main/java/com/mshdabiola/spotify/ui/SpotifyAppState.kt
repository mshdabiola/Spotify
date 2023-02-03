package com.mshdabiola.spotify.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

data class SpotifyAppState(
    val windowSizeClass: WindowSizeClass,
    val navHostController: NavHostController,
)

@Composable
fun rememberSpotifyAppState(
    windowSizeClass: WindowSizeClass,
    navHostController: NavHostController = rememberNavController(),
): SpotifyAppState {
    return remember(key1 = windowSizeClass) {
        SpotifyAppState(windowSizeClass, navHostController)
    }
}
