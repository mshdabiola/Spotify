package com.mshdabiola.data.model

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track
import com.mshdabiola.network.model.comp.NetworkAlbum
import com.mshdabiola.network.model.comp.NetworkArtist
import com.mshdabiola.network.model.comp.NetworkCategory
import com.mshdabiola.network.model.comp.NetworkPlaylist
import com.mshdabiola.network.model.comp.NetworkTrack


fun NetworkTrack.asTrack() = Track(
    id = id,
    name = name,
    duration = durationMs ?: 0,
    artist = artists.map { it.asArtiste() },
    image = album?.images?.first()?.url ?: "",
    previewUri = previewUrl,
    type = type,
    releaseDate = album?.releaseDate?.toLong() ?: System.currentTimeMillis()
)

fun NetworkPlaylist.asPlaylist() = Playlist(
    id = id,
    name = name,
    description = description,
    image = images.firstOrNull()?.url ?: "",
)

fun NetworkAlbum.asAlbum() = Album(
    id = id,
    name = name,
    releaseDate = releaseDate?.toLong() ?: 0,
    type = type,
    albumType = albumType ?: "",
    imageUri = images.first().url,
    artist = artists.map { it.asArtiste() },
    tracks = tracks?.items?.map { it.asTrack().copy(image = images.first().url) } ?: emptyList()
)

fun NetworkCategory.asCategory() = Category(name, id, icons.first().url)


fun NetworkArtist.asArtiste() =
    Artist(id = id, name = name, image = images?.first()?.url ?: "", type)