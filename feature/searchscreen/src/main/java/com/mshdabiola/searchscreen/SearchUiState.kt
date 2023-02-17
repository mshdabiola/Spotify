package com.mshdabiola.searchscreen

import com.mshdabiola.ui.data.GenreUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

data class SearchUiState(
    val genres: ImmutableList<GenreUiState> = emptyList<GenreUiState>().toImmutableList(),
    val tracks: ImmutableList<TrackUiState> = emptyList<TrackUiState>().toImmutableList()
)
