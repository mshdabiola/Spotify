package com.mshdabiola.model

data class Playlist(
    val id : String,
    val name : String,
    val description : String,
    val image : String,
    val tracks : List<Track>
)
