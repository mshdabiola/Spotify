package com.mshdabiola.model

data class Album(
    val id :String,
    val name : String,
    val releaseDate:Long,
    val albumType : String,
    val type:String,
    val artist:List<Artist>,
    val imageUri : String,
    val tracks :List<Track>
    )
