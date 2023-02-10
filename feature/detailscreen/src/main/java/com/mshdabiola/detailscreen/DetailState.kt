package com.mshdabiola.detailscreen

import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.PlaylistUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

data class DetailState(
    val image : String="",
    val title : String="Only you",
    val artists : ImmutableList<ArtistUiState> = emptyList<ArtistUiState>().toImmutableList(),
    val subTitle : String="Single * 2023",
    val trackList : ImmutableList<TrackUiState> = emptyList<TrackUiState>().toImmutableList(),
    val date : String="February 2,2034",
    val playList: ImmutableList<PlaylistUiState> = emptyList<PlaylistUiState>().toImmutableList()

)
