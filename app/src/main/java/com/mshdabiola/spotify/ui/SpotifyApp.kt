package com.mshdabiola.spotify.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import com.mshdabiola.designsystem.theme.SpotifyAppTheme
import com.mshdabiola.spotify.navigation.SpotifyAppNavHost

@Composable
fun SpotifyApp(
    windowSizeClass: WindowSizeClass,
    noteAppState: SpotifyAppState = rememberSpotifyAppState(windowSizeClass = windowSizeClass),
) {
    SpotifyAppTheme {
        SpotifyAppNavHost(navController = noteAppState.navHostController)
    }
}
