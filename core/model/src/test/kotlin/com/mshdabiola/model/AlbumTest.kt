package com.mshdabiola.model

import kotlin.test.Test
import kotlin.test.assertEquals


class AlbumTest{

    @Test
    fun createClass(){
        val album=Album(
            id = "Lyndi",
            name = "Yoba",
            releaseDate = "Alessandra",
            albumType = "Nathaniel",
            type = "Teryn",
            artist = "Bernadette",
            imageUri = "Yomaira",
            tracks = listOf()
        )

        assertEquals("Yoba",album.name)
    }
}