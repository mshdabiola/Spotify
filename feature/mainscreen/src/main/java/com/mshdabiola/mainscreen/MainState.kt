package com.mshdabiola.mainscreen

import com.mshdabiola.ui.data.AlbumUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList


data class MainState(
    val newRelease : ImmutableList<AlbumUiState> = emptyList<AlbumUiState>().toImmutableList(),
    val recommendations : ImmutableList<AlbumUiState> = emptyList<AlbumUiState>().toImmutableList()
)
