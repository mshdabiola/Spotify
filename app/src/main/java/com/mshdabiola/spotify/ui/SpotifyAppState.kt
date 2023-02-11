package com.mshdabiola.spotify.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination.Companion.hierarchy
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
import timber.log.Timber

data class SpotifyAppState(
    val windowSizeClass: WindowSizeClass,
    val navHostController: NavHostController,
){
    val listOfDestination=TopLevelDestination.values().toList()
    val currentDestination
       @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination

    val currentTopDestination
       @Composable get() = when(currentDestination?.route){
           libraryRoute->TopLevelDestination.LIBRARY
           searchRoute->TopLevelDestination.SEARCH
           mainRoute->TopLevelDestination.HOME
           else-> null
    }

//    val currentTop
//    @Composable ge()=when{
//        currenDestnation?.
//    }

    fun navigateToTopLevel(destination: TopLevelDestination){


       // Timber.d(navHostController.)
        //navHostController.clearBackStack(mainRoute)
       Timber.d( navHostController.currentDestination?.route)
        if (navHostController.currentDestination?.route?.contains("detail") == true){
            navHostController.popBackStack()
        }


        val navOption= navOptions {
            popUpTo(navHostController.graph.findStartDestination().id){
                saveState=true
            }
            launchSingleTop=true
            restoreState=true

        }

        when(destination){
            TopLevelDestination.HOME->navHostController.navigateToMain(navOption)
            TopLevelDestination.SEARCH->navHostController.navigateToSearch(navOption)
            TopLevelDestination.LIBRARY->navHostController.navigateToLibrary(navOption)
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
