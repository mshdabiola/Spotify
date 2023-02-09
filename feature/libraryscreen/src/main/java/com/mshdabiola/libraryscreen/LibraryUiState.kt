package com.mshdabiola.libraryscreen

import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

data class LibraryUiState(
    val userTracks : ImmutableList<TrackUiState> = emptyList<TrackUiState>().toImmutableList(),
    val userAlbums : ImmutableList<AlbumUiState> = emptyList<AlbumUiState>().toImmutableList()
)
