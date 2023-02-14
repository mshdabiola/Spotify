package com.mshdabiola.mainscreen

import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.CategoryUIState
import com.mshdabiola.ui.data.PlaylistUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList


data class MainState(
    val showLogin: Boolean = true,
    val newRelease: ImmutableList<AlbumUiState> = emptyList<AlbumUiState>().toImmutableList(),
    val recommendations: ImmutableList<TrackUiState> = emptyList<TrackUiState>().toImmutableList(),
    val featurePlaylist: ImmutableList<PlaylistUiState> = emptyList<PlaylistUiState>().toImmutableList(),
    val category: ImmutableList<CategoryUIState> = emptyList<CategoryUIState>().toImmutableList(),
    val relatedArtiste: ImmutableList<ArtistUiState> = emptyList<ArtistUiState>().toImmutableList()
)
