package com.mshdabiola.network.fake

import com.mshdabiola.network.NetworkDataSource
import com.mshdabiola.network.model.CategoryItem
import com.mshdabiola.network.model.NewRelease
import com.mshdabiola.network.model.Recommendation
import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Feature
import com.mshdabiola.network.model.comp.Playlists
import com.mshdabiola.network.model.comp.Track
import com.mshdabiola.network.model.comp.Tracks
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

class FakeNetworkDataSource : NetworkDataSource {
    private val path="/Users/user/AndroidStudioProjects/Spotify/data"
    override suspend fun getRecommendation(): List<Track> {
        val name="recommendations.json"
        val jsonString= File(path,name).readText()
        val recommendation : Recommendation=Json.decodeFromString(jsonString)
        return recommendation.tracks
    }

    override suspend fun getCategory(): Categories {
        val name="browse_category.json"
        val jsonString= File(path,name).readText()
        val categoryItem : CategoryItem=Json.decodeFromString(jsonString)
        return categoryItem.categories
    }

    override suspend fun getFeaturePlaylist(): Playlists {
        val name="browse_featured_playlist.json"
        val jsonString= File(path,name).readText()
        val feature : Feature=Json.decodeFromString(jsonString)
        return feature.playlists
    }

    override suspend fun getNewRelease(): Albums {
        val name="new_release.json"
        val jsonString= File(path,name).readText()
        val newRelease : NewRelease=Json.decodeFromString(jsonString)
        return newRelease.albums
    }

}