package com.mshdabiola.ui.data

import kotlinx.collections.immutable.ImmutableList

data class AlbumUiState(
    val id :String,
    val name : String,
    val releaseDate:Long,
    val albumType : String,
    val type:String,
    val artist:ImmutableList<ArtistUiState>,
    val imageUri : String,
    )
