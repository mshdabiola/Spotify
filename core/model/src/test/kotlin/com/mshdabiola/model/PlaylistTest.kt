package com.mshdabiola.model

import kotlin.test.Test
import kotlin.test.assertEquals


class PlaylistTest {
    @Test
    fun create() {
        val playlist = Playlist(
            id = "Vikas",
            name = "Kade",
            description = "Jarryd",
            image = "Alessandra",
            //    tracks = listOf()
        )

        assertEquals("Kade", playlist.name)
    }
}