package com.mshdabiola.network

import com.mshdabiola.network.model.OnePlaylist
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.NetworkAlbum
import com.mshdabiola.network.model.comp.NetworkAlbums
import com.mshdabiola.network.model.comp.NetworkArtist
import com.mshdabiola.network.model.comp.NetworkPlaylists
import com.mshdabiola.network.model.comp.NetworkTrack


interface NetworkDataSource {
    suspend fun getRecommendation(): List<NetworkTrack>

    suspend fun getCategory(): Categories


    suspend fun getFeaturePlaylist(): NetworkPlaylists

    suspend fun getNewRelease(): NetworkAlbums

    suspend fun getRelatedArtists(): List<NetworkArtist>

    suspend fun search(query: String, type: String): List<NetworkTrack>

    suspend fun getUserAlbum(): List<NetworkAlbum>

    suspend fun getUserTracks(): List<NetworkTrack>

    suspend fun getTrack(id: String): NetworkTrack

    suspend fun getAlbum(id: String): NetworkAlbum

    suspend fun getPlaylist(id: String): OnePlaylist

    suspend fun getArtist(id: String): NetworkArtist
}


