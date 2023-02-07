package com.mshdabiola.network

import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Playlists
import com.mshdabiola.network.model.comp.Track
import com.mshdabiola.network.model.comp.Tracks


interface NetworkDataSource{
    suspend fun getRecommendation(): List<Track>

    suspend fun getCategory(): Categories


    suspend fun getFeaturePlaylist(): Playlists

    suspend fun getNewRelease(): Albums
}


