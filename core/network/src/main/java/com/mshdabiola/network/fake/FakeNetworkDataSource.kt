package com.mshdabiola.network.fake

import com.mshdabiola.network.NetworkDataSource
import com.mshdabiola.network.model.CategoryItem
import com.mshdabiola.network.model.NewRelease
import com.mshdabiola.network.model.Recommendation
import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Feature
import com.mshdabiola.network.model.comp.NetworkPlaylists
import com.mshdabiola.network.model.comp.NetworkTrack
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class FakeNetworkDataSource : NetworkDataSource {
    private val path="/Users/user/AndroidStudioProjects/Spotify/data"
    private val json = Json { ignoreUnknownKeys = true }

    override suspend fun getRecommendation(): List<NetworkTrack> {
        val name="recommendations.json"
        val jsonString= File(path,name).readText()
        val recommendation : Recommendation= json.decodeFromString(jsonString)
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
        val newRelease : NewRelease=json.decodeFromString(jsonString)
        return newRelease.albums
    }

}