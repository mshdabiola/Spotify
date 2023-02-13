package com.mshdabiola.spotify.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.mshdabiola.spotify.R


enum class TopLevelDestination(
    val selectIcon : Int,
    val unSelectIcon:Int,
    val text : String
) {
    HOME(selectIcon = R.drawable.home_select, unSelectIcon = R.drawable.home, text="Home"),
    SEARCH(selectIcon = R.drawable.search_select, unSelectIcon = R.drawable.search, text = "Search"),
    LIBRARY(selectIcon = R.drawable.library_select, unSelectIcon = R.drawable.library, text = "Library")
}