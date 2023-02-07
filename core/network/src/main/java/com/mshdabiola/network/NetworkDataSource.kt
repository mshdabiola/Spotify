package com.mshdabiola.network

import com.mshdabiola.network.model.Albums
import com.mshdabiola.network.model.Categories
import com.mshdabiola.network.model.Playlists
import com.mshdabiola.network.model.Tracks


interface NetworkDataSource{
    suspend fun getRecommendation(): Tracks

    suspend fun getCategory(): Categories


    suspend fun getFeaturePlaylist(): Playlists

    suspend fun getNewRelease(): Albums
}


