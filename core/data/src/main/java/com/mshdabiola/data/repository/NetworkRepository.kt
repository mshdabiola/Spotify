package com.mshdabiola.data.repository

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track

interface NetworkRepository {

    suspend fun getRecommendation(): List<Track>

    suspend fun getFeaturePlaylist():List<Playlist>

    suspend fun getCategory () : List<Category>

    suspend fun getArtiste():List<Artist>

    suspend fun getNewRelease():List<Album>
}