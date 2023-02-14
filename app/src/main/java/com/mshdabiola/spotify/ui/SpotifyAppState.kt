package com.mshdabiola.spotify.ui

import android.net.Uri
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.session.MediaController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.mshdabiola.libraryscreen.libraryRoute
import com.mshdabiola.libraryscreen.navigateToLibrary
import com.mshdabiola.mainscreen.mainRoute
import com.mshdabiola.mainscreen.navigateToMain
import com.mshdabiola.searchscreen.navigateToSearch
import com.mshdabiola.searchscreen.searchRoute
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import timber.log.Timber

data class SpotifyAppState(
    val windowSizeClass: WindowSizeClass,
    val navHostController: NavHostController,
) {
    val listOfDestination = TopLevelDestination.values().toList()
    val showBar = mutableStateOf(true)



    val currentDestination
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val currentTopDestination
        @Composable get() = when (currentDestination?.route) {
            libraryRoute -> TopLevelDestination.LIBRARY
            searchRoute -> TopLevelDestination.SEARCH
            mainRoute -> TopLevelDestination.HOME
            else -> null
        }

    fun setShowBar(show: Boolean) {
        showBar.value = show
    }

    fun setTracks(trackList: List<TrackUiState>) {
        val m= MediaItem.Builder()
            .setMediaId("https://p.scdn.co/mp3-preview/facd9e5b75514daefb81d6492da242068873fe93?cid=774b29d4f13844c495f206cafdad9c86")
            .setMediaMetadata(
                MediaMetadata.Builder()
                    .setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
                    .setArtworkUri(Uri.parse("https://i.scdn.co/image/ab67616d0000b27341462de7dd99c99f01a96695"))
                    .setAlbumTitle("YBAG")
                    .setTitle("2 Thousand")
                    .setArtist("Laycon")

                    .build()
            )
            .build()


    }

    fun navigateToTopLevel(destination: TopLevelDestination) {


        // Timber.d(navHostController.)
        //navHostController.clearBackStack(mainRoute)
        Timber.d(navHostController.currentDestination?.route)
        if (navHostController.currentDestination?.route?.contains("detail") == true) {
            navHostController.popBackStack()
        }


        val navOption = navOptions {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true

        }

        when (destination) {
            TopLevelDestination.HOME -> navHostController.navigateToMain(navOption)
            TopLevelDestination.SEARCH -> navHostController.navigateToSearch(navOption)
            TopLevelDestination.LIBRARY -> navHostController.navigateToLibrary(navOption)
        }

    }


}

@Composable
fun rememberSpotifyAppState(
    windowSizeClass: WindowSizeClass,
    navHostController: NavHostController = rememberNavController(),
): SpotifyAppState {
    return remember(key1 = windowSizeClass) {
        SpotifyAppState(windowSizeClass, navHostController)
    }
}
