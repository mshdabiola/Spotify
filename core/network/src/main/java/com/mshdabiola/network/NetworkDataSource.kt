package com.mshdabiola.network

import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.NetworkPlaylists
import com.mshdabiola.network.model.comp.NetworkTrack


interface NetworkDataSource{
    suspend fun getRecommendation(): List<NetworkTrack>

    suspend fun getCategory(): Categories


    suspend fun getFeaturePlaylist(): NetworkPlaylists

    suspend fun getNewRelease(): Albums
}


