package com.mshdabiola.data.repository

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track

interface NetworkRepository {
    suspend fun recommendation(): Result<List<Track>>

    suspend fun newRelease(): Result<List<Album>>

    suspend fun featurePlaylist(): Result<List<Playlist>>

    suspend fun getArtiste() : Result<List<Artist>>
}
