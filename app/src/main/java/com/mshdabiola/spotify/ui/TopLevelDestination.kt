package com.mshdabiola.spotify.ui

import com.mshdabiola.spotify.R


enum class TopLevelDestination(
    val selectIcon: Int,
    val unSelectIcon: Int,
    val text: String
) {
    HOME(selectIcon = R.drawable.home_select, unSelectIcon = R.drawable.home, text = "Home"),
    SEARCH(
        selectIcon = R.drawable.search_select,
        unSelectIcon = R.drawable.search,
        text = "Search"
    ),
    LIBRARY(
        selectIcon = R.drawable.library_select,
        unSelectIcon = R.drawable.library,
        text = "Library"
    )
}