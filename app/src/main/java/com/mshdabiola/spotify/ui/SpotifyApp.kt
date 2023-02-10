package com.mshdabiola.spotify.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        Surface() {
            Box (Modifier.fillMaxHeight()){

                SpotifyAppNavHost(
                    Modifier,//.padding(bottom = 80.dp),
                    navController = noteAppState.navHostController)
                SpotifyBottomNavBar(
                    modifier = Modifier.align(Alignment.BottomCenter),
                    topLevelDestinations = noteAppState.listOfDestination,
                    onNavigateToTopNav = noteAppState::navigateToTopLevel,
                    currentDestination = noteAppState.currentTopDestination
                )
            }
        }



    }
}

@Composable
fun SpotifyBottomNavBar(
    modifier: Modifier,
    topLevelDestinations: List<TopLevelDestination>,
    onNavigateToTopNav : (TopLevelDestination)->Unit,
    currentDestination : TopLevelDestination?
) {
    NavigationBar(
        modifier=modifier.background(Brush.verticalGradient(0f to Color.Transparent,0.8f to Color.Black)),
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