package com.mshdabiola.network.fake

import com.mshdabiola.network.NetworkDataSource
import com.mshdabiola.network.model.CategoryItem
import com.mshdabiola.network.model.PagingNetworkAlbums
import com.mshdabiola.network.model.PagingNetWorkTracks
import com.mshdabiola.network.model.OnePlaylist
import com.mshdabiola.network.model.UserAlbums
import com.mshdabiola.network.model.UserTracks
import com.mshdabiola.network.model.comp.NetworkAlbums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Feature
import com.mshdabiola.network.model.comp.NetworkAlbum
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
        val recommendation : PagingNetWorkTracks= json.decodeFromString(jsonString)
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

    override suspend fun getNewRelease(): NetworkAlbums {
        val name="new_release.json"
        val jsonString= File(path,name).readText()
        val newRelease : PagingNetworkAlbums=json.decodeFromString(jsonString)
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
        val recommendation : PagingNetWorkTracks= json.decodeFromString(jsonString)
        return recommendation.tracks
    }

    override suspend fun getUserAlbum(): List<NetworkAlbum> {
        val name="user_album.json"
        val jsonString= File(path,name).readText()
        val userAlbums:UserAlbums= json.decodeFromString(jsonString)
        return userAlbums.items.map { it.album }
    }

    override suspend fun getUserTracks(): List<NetworkTrack> {
        val name="user_tracks.json"
        val jsonString= File(path,name).readText()
        val networkTracks:UserTracks= json.decodeFromString(jsonString)
        return networkTracks.items.map { it.track }
    }

    override suspend fun getTrack(id: String): NetworkTrack {
        val name="track.json"
        val jsonString= File(path,name).readText()
        return json.decodeFromString(jsonString)
    }

    override suspend fun getAlbum(id: String): NetworkAlbum {
        val name="albumm.json"
        val jsonString= File(path,name).readText()
        return json.decodeFromString(jsonString)
    }

    override suspend fun getPlaylist(id: String): OnePlaylist {
        val name = "playlistnew.json"
        val jsonString = File(path, name).readText()
        return json.decodeFromString(jsonString)
    }

    override suspend fun getArtist(id: String): NetworkArtist {
        val name="artist.json"
        val jsonString= File(path,name).readText()
        return json.decodeFromString(jsonString)
    }

}