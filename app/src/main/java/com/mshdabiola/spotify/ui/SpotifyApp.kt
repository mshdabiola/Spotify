package com.mshdabiola.spotify.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.mshdabiola.designsystem.theme.SpotifyAppTheme
import com.mshdabiola.spotify.navigation.SpotifyAppNavHost

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpotifyApp(
    windowSizeClass: WindowSizeClass,
    noteAppState: SpotifyAppState = rememberSpotifyAppState(windowSizeClass = windowSizeClass),
) {
    SpotifyAppTheme {
        Scaffold(
            bottomBar = {
                SpotifyBottomNavBar(
                    topLevelDestinations = noteAppState.listOfDestination,
                    onNavigateToTopNav = noteAppState::navigateToTopLevel,
                    currentDestination = noteAppState.currentTopDestination
                )
            }
        ) {
            SpotifyAppNavHost(
                Modifier.padding(it),
                navController = noteAppState.navHostController)
        }

    }
}

@Composable
fun SpotifyBottomNavBar(
    topLevelDestinations: List<TopLevelDestination>,
    onNavigateToTopNav : (TopLevelDestination)->Unit,
    currentDestination : TopLevelDestination?
) {
    NavigationBar(
        modifier=Modifier.background(Brush.verticalGradient(0f to Color.Transparent,0.8f to Color.Black)),
        containerColor = Color.Transparent,
        contentColor = Color.Yellow
    ) {
        topLevelDestinations.forEach {
            val isSelected=currentDestination==it
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
                icon = { Icon(imageVector = if (isSelected)it.selectIcon else it.unSelectIcon, contentDescription = "") })
        }
    }

}

fun NavDestination?.isTop(destination: TopLevelDestination)=
    this?.hierarchy?.any { it.route?.contains(destination.name) ?:false} ?:false