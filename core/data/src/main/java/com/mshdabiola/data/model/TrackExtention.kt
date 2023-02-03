package com.mshdabiola.data.model

import com.mshdabiola.network.model.component.Album
import com.mshdabiola.network.model.component.Track

fun Album.toTrack()=com.mshdabiola.model.Album(
    title = name,
    type = type ,
    artist=artists.joinToString {it.name},
    imageUri =images.first().url,
    id = id
)

fun Track.toAlbum()=com.mshdabiola.model.Album(
    title = name,
    type = type ,
    artist=artists.joinToString {it.name},
    imageUri =album.images.first().url,
    id = id
)