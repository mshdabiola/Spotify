package com.mshdabiola.ui

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Playlist
import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.PlaylistUiState

fun Album.toTrackUiState()= AlbumUiState(id, title, type, artist, imageUri)
fun Artist.toArtistUiState()=ArtistUiState(id,name, imageUri)

fun Playlist.toPlaylistUiState()=PlaylistUiState(id, name, desc, imageUri)