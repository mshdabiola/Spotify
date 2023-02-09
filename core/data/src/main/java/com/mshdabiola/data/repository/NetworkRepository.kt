package com.mshdabiola.data.repository

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track

interface NetworkRepository {

    suspend fun getRecommendation(): Result <List<Track>>

    suspend fun getFeaturePlaylist():Result<List<Playlist>>

    suspend fun getCategory () :Result< List<Category>>

    suspend fun getArtiste():Result<List<Artist>>

    suspend fun search(query:String, type:String):Result<List<Track>>

    suspend fun getNewRelease():Result<List<Album>>
}