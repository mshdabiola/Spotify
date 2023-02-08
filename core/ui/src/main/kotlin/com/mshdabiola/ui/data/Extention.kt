package com.mshdabiola.ui.data

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.PlaylistUiState

fun Album.toAlbumUiState()= AlbumUiState(id, name, releaseDate, albumType, type, artist, imageUri)
fun Artist.toArtistUiState()=ArtistUiState(id, name, image, type)

fun Playlist.toPlaylistUiState()=PlaylistUiState(id, name, description, image)

fun Category.toCategoryUiState()=CategoryUIState(name, id, image)