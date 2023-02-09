package com.mshdabiola.network

import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.NetworkArtist
import com.mshdabiola.network.model.comp.NetworkPlaylists
import com.mshdabiola.network.model.comp.NetworkTrack
import com.mshdabiola.network.model.comp.NetworkTracks2


interface NetworkDataSource{
    suspend fun getRecommendation(): List<NetworkTrack>

    suspend fun getCategory(): Categories


    suspend fun getFeaturePlaylist(): NetworkPlaylists

    suspend fun getNewRelease(): Albums

    suspend fun getRelatedArtists():List<NetworkArtist>

    suspend fun search(query:String,type:String): List<NetworkTrack>
}


