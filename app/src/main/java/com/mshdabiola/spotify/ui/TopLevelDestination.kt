package com.mshdabiola.spotify.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryBooks
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryBooks
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector


enum class TopLevelDestination(
    val selectIcon : ImageVector,
    val unSelectIcon:ImageVector,
    val text : String
) {
    HOME(selectIcon = Icons.Default.Home, unSelectIcon = Icons.Outlined.Home, text="Home"),
    SEARCH(selectIcon = Icons.Default.Search, unSelectIcon = Icons.Outlined.Search, text = "Search"),
    LIBRARY(selectIcon = Icons.Default.LibraryBooks, unSelectIcon = Icons.Outlined.LibraryBooks, text = "Library")
}