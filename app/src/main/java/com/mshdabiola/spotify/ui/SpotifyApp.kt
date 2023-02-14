package com.mshdabiola.spotify.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.mshdabiola.designsystem.theme.SpotifyAppTheme
import com.mshdabiola.libraryscreen.libraryRoute
import com.mshdabiola.mainscreen.mainRoute
import com.mshdabiola.searchscreen.searchRoute
import com.mshdabiola.spotify.MainViewModel
import com.mshdabiola.spotify.navigation.SpotifyAppNavHost
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.toImmutableList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotifyApp(
    windowSizeClass: WindowSizeClass,
    noteAppState: SpotifyAppState = rememberSpotifyAppState(windowSizeClass = windowSizeClass),
    mainViewModel: MainViewModel
) {
    val mediaData = mainViewModel.mediaData.collectAsStateWithLifecycle()

    SpotifyAppTheme {
        Surface {
            Box (
                Modifier
                    .statusBarsPadding()
                    .fillMaxHeight()){

                SpotifyAppNavHost(
                    Modifier,//.padding(bottom = 80.dp),
                    navController = noteAppState.navHostController,
                    showNavBar = noteAppState::setShowBar,
                    onMediaItems = mainViewModel::setMediaItems
                    )

                if (noteAppState.showBar.value) {
                    Column(Modifier.align(Alignment.BottomCenter)) {

                            PlayerBar(
                                modifier=Modifier.padding(horizontal = 16.dp),
                                mediaData = mediaData.value,
                                onPlay = mainViewModel::onPlay
                            )

                        SpotifyBottomNavBar(
                            modifier = Modifier,
                            topLevelDestinations = noteAppState.listOfDestination,
                            onNavigateToTopNav = noteAppState::navigateToTopLevel,
                            currentDestination = noteAppState.currentDestination
                        )
                    }

                }
            }
        }



    }
}

@Composable
fun SpotifyBottomNavBar(
    modifier: Modifier,
    topLevelDestinations: List<TopLevelDestination>,
    onNavigateToTopNav : (TopLevelDestination)->Unit,
    currentDestination : NavDestination?
) {
    NavigationBar(
        modifier=modifier.background(Brush.verticalGradient(0f to Color.Transparent,0.8f to Color.Black)),
        containerColor = Color.Transparent,
        contentColor = Color.Yellow
    ) {
        topLevelDestinations.forEach {
            val isSelected=currentDestination?.isTop(it) ?:false
            NavigationBarItem(
                modifier = Modifier.background(Color.Transparent),
                colors=NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    unselectedIconColor = Color.DarkGray,
                    indicatorColor = Color.Transparent,
                    selectedTextColor = Color.White,
                    unselectedTextColor = Color.DarkGray
                ),
                selected = isSelected,
                onClick = { onNavigateToTopNav(it) },
                icon = { Icon(painter = painterResource(id =if (isSelected)it.selectIcon else it.unSelectIcon), contentDescription = "") })
        }
    }

}

//Todo("incorrect nav bar after to detail")
fun NavDestination?.isTop(destination: TopLevelDestination)=
    this?.hierarchy?.any { it.route?.contains(routeArray[destination.ordinal]) ?:false} ?:false

val routeArray= arrayOf(mainRoute, searchRoute, libraryRoute)