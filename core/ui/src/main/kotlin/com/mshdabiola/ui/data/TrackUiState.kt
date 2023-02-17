package com.mshdabiola.ui.data

import kotlinx.collections.immutable.ImmutableList

data class TrackUiState(
    val id: String,
    val name: String,
    val artist: ImmutableList<ArtistUiState>,
    val duration: Int,
    val image: String,
    val previewUri: String?,
    val type: String
)
