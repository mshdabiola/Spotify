package com.mshdabiola.network

import com.mshdabiola.network.model.CategoryItem
import com.mshdabiola.network.model.PagingNetworkAlbums
import com.mshdabiola.network.model.PagingNetWorkTracks
import com.mshdabiola.network.model.Search
import com.mshdabiola.network.model.UserAlbums
import com.mshdabiola.network.model.UserTracks
import com.mshdabiola.network.model.comp.NetworkAlbums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Feature
import com.mshdabiola.network.model.comp.Message
import com.mshdabiola.network.model.comp.NetworkAlbum
import com.mshdabiola.network.model.comp.NetworkArtist
import com.mshdabiola.network.model.comp.NetworkPlaylist
import com.mshdabiola.network.model.comp.NetworkPlaylists
import com.mshdabiola.network.model.comp.NetworkTrack
import com.mshdabiola.network.model.comp.RelatedArtists
import com.mshdabiola.network.request.Request
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.HttpStatusCode
import javax.inject.Inject

class INetworkDataSource @Inject constructor(
    private val httpClient: HttpClient,
) : NetworkDataSource {

    override suspend fun getRecommendation(): List<NetworkTrack> {
        val response = httpClient.get(
            Request.Recommendations(
                limit = "10",
                market = "NG",
                seed_artists = "4NHQUGzhtTLFvgF5SZesLK",
                seed_genres = "classical",
                seed_tracks = "0c6xIDDpzE81m2q797ordA"
            )
        )
        val netWorkTracks: PagingNetWorkTracks= if (response.status== HttpStatusCode.OK){
            response.body()
        }else
        {
            val message :Message=response.body()
            throw Exception(message.error.message)
        }


        return netWorkTracks.tracks
    }

    override suspend fun getCategory(): Categories {

        val response=httpClient.get(Request.Browse.Category(
            country = "NG",
            locale = "yo_NG",
            limit = "10",
            offset = "0"
        ))
        val categoryItem:CategoryItem=getResult(response)
        return categoryItem.categories
    }


    override suspend fun getFeaturePlaylist(): NetworkPlaylists {
        val response=httpClient.get(Request.Browse.FeaturedPlaylist(
            country = "NG",
            locale = "yo_NG",
            limit = "10",
            offset = "0"
        ))

        val feature:Feature=getResult(response)

        return feature.playlists
    }

    override suspend fun getNewRelease(): NetworkAlbums {
        val response=httpClient.get(
        Request.Browse.NewReleases(
            limit = "10",
            country = "NG",
            offset = "0"
        )
        )
        val newRelease: PagingNetworkAlbums = getResult(response)
        return newRelease.albums
    }

    override suspend fun getRelatedArtists(): List<NetworkArtist> {
        val response=httpClient.get(Request.Artist.Id.RelatedArtists(
            Request.Artist.Id(id="1E5hfn5BduN2nnoZCJmUVG")))

        val relatedArtists: RelatedArtists=getResult(response)
        return relatedArtists.artists
    }

    override suspend fun search(query: String, type: String): List<NetworkTrack> {
       val response=httpClient.get(Request.Search(q=query, type = type, offset = "0", limit = "10"))

        val netWorkTracks: Search= getResult(response)


        return netWorkTracks.tracks.items
    }

    override suspend fun getUserAlbum(): List<NetworkAlbum> {
        val response=httpClient.get(Request.Me.Album())

        val userAlbums:UserAlbums=getResult(response)
        return userAlbums.items.map { it.album }
    }

    override suspend fun getUserTracks(): List<NetworkTrack> {
        val response=httpClient.get(Request.Me.Tracks())

        val userTracks : UserTracks = getResult(response)
        return userTracks.items.map { it.track }
    }

    override suspend fun getTrack(id: String): NetworkTrack {
        val response=httpClient.get(Request.Tracks.Id(id = id))
       return getResult(response)
    }

    override suspend fun getAlbum(id: String): NetworkAlbum {
        val response=httpClient.get(Request.Albums.Id(id = id))
        return getResult(response)
    }

    override suspend fun getPlaylist(id: String): NetworkPlaylist {
        val response=httpClient.get(Request.Playlists.Id(id = id))
        return getResult(response)
    }

    override suspend fun getArtist(id: String): NetworkArtist {
        val response=httpClient.get(Request.Artist.Id(id = id))
        return getResult(response)
    }

    suspend inline fun <reified T>getResult(response: HttpResponse):T{
        return if (response.status== HttpStatusCode.OK){
            response.body()
        }else{
            val message:Message=response.body()
            throw Exception(message.error.message)
        }

    }


}







