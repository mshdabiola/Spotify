package com.mshdabiola.model

import kotlin.test.Test
import kotlin.test.assertEquals


class ArtistTest {
    @Test
    fun create() {
        val artist = Artist(
            id = "Raina",
            name = "Raguel",
            image = "Andre",
            type = "Lakea"
        )

        assertEquals("Raina", artist.id)
    }
}