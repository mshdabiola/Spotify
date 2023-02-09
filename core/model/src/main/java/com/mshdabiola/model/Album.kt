package com.mshdabiola.model

data class Album(
    val id :String,
    val name : String,
    val releaseDate:String,
    val albumType : String,
    val type:String,
    val artist:String,
    val imageUri : String,
   // val tracks :List<Track>
    ) :Music
