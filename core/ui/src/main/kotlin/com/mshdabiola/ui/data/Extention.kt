package com.mshdabiola.ui.data

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track
import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.PlaylistUiState
import kotlinx.collections.immutable.toImmutableList

fun Album.toAlbumUiState()= AlbumUiState(id, name, releaseDate, albumType, type, artist.map { it.toArtistUiState() }.toImmutableList(), imageUri)
fun Artist.toArtistUiState()=ArtistUiState(id, name, image, type)

fun Playlist.toPlaylistUiState()=PlaylistUiState(id, name, description, image)

fun Category.toCategoryUiState()=CategoryUIState(name, id, image)

fun Track.toTrackUiState()=TrackUiState(id, name, artist.map { it.toArtistUiState() }.toImmutableList(), duration, image, previewUri, type)