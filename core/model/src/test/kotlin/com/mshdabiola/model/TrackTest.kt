package com.mshdabiola.model

import kotlin.test.Test
import kotlin.test.assertEquals


class TrackTest{

    @Test
    fun create(){
        val track=Track(
            id = "Ahmed",
            name = "Thera",
            artist = "Tonika",
            duration = 4,
            image = "Forest",
            previewUri = "Jorel",
            type = "Charlette"
        )
        assertEquals("Ahmed",track.id)
    }
}