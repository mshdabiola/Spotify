package com.mshdabiola.network.fake

import com.mshdabiola.network.NetworkDataSource
import com.mshdabiola.network.model.CategoryItem
import com.mshdabiola.network.model.NetworkAlbums
import com.mshdabiola.network.model.NetWorkTracks
import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Feature
import com.mshdabiola.network.model.comp.NetworkArtist
import com.mshdabiola.network.model.comp.NetworkPlaylists
import com.mshdabiola.network.model.comp.NetworkTrack
import com.mshdabiola.network.model.comp.RelatedArtists
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class FakeNetworkDataSource : NetworkDataSource {
    private val path="/Users/user/AndroidStudioProjects/Spotify/data"
    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun getRecommendation(): List<NetworkTrack> {
        val name="recommendations.json"
        val jsonString= File(path,name).readText()
        val recommendation : NetWorkTracks= json.decodeFromString(jsonString)
        return recommendation.tracks
    }

    override suspend fun getCategory(): Categories {
        val name="browse_category.json"
        val jsonString= File(path,name).readText()
        val categoryItem : CategoryItem=json.decodeFromString(jsonString)
        return categoryItem.categories
    }

    override suspend fun getFeaturePlaylist(): NetworkPlaylists {
        val name="browse_featured_playlist.json"
        val jsonString= File(path,name).readText()
        val feature : Feature=json.decodeFromString(jsonString)
        return feature.playlists
    }

    override suspend fun getNewRelease(): Albums {
        val name="new_release.json"
        val jsonString= File(path,name).readText()
        val newRelease : NetworkAlbums=json.decodeFromString(jsonString)
        return newRelease.albums
    }

    override suspend fun getRelatedArtists(): List<NetworkArtist> {
        val name="artists.json"
        val jsonString= File(path,name).readText()
        val relatedArtists:RelatedArtists=json.decodeFromString(jsonString)
        return relatedArtists.artists
    }

    override suspend fun search(query: String, type: String): List<NetworkTrack> {
        val name="recommendations.json"
        val jsonString= File(path,name).readText()
        val recommendation : NetWorkTracks= json.decodeFromString(jsonString)
        return recommendation.tracks
    }

}