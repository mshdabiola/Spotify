package com.mshdabiola.data.model

import com.mshdabiola.model.Album
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track
import com.mshdabiola.network.model.comp.NetworkAlbum
import com.mshdabiola.network.model.comp.NetworkCategory
import com.mshdabiola.network.model.comp.NetworkPlaylist
import com.mshdabiola.network.model.comp.NetworkTrack
import com.mshdabiola.network.model.comp.NetworkTracks


fun NetworkTrack.asTrack()=Track(
    id=id,
    name=name,
    duration = durationMs?:0,
    artist = artists.joinToString { it.name },
    image = album.images.first().url,
    previewUri = previewUrl?:"",
    type = type
)
fun NetworkPlaylist.asPlaylist()=Playlist(
    id = id,
    name = name,
    description=description,
    image= images.firstOrNull()?.url ?:"",
)

fun NetworkAlbum.asAlbum()=Album(
    id = id,
    name=name,
    releaseDate = releaseDate?:"",
    type=type,
    albumType = albumType?:"",
    imageUri = images.first().url,
    artist = artists.joinToString { it.name },
)

fun NetworkCategory.asCategory()=Category(name,id,icons.first().url)