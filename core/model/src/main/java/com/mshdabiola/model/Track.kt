package com.mshdabiola.model

data class Track(
    val id : String,
    val name : String,
    val artist: String,
    val duration : Int,
    val image : String,
    val previewUri : String,
    val type : String
)
