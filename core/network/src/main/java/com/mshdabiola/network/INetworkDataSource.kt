package com.mshdabiola.network

import com.mshdabiola.network.model.CategoryItem
import com.mshdabiola.network.model.NetworkAlbums
import com.mshdabiola.network.model.NetWorkTracks
import com.mshdabiola.network.model.Search
import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Feature
import com.mshdabiola.network.model.comp.Message
import com.mshdabiola.network.model.comp.NetworkArtist
import com.mshdabiola.network.model.comp.NetworkPlaylists
import com.mshdabiola.network.model.comp.NetworkTrack
import com.mshdabiola.network.model.comp.NetworkTracks2
import com.mshdabiola.network.model.comp.RelatedArtists
import com.mshdabiola.network.request.Request
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
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
        val netWorkTracks: NetWorkTracks= if (response.status== HttpStatusCode.OK){
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
        val categoryItem:CategoryItem=if (response.status== HttpStatusCode.OK){
            response.body()
        }else{
            val message:Message=response.body()
            throw Exception(message.error.message)
        }
        return categoryItem.categories
    }


    override suspend fun getFeaturePlaylist(): NetworkPlaylists {
        val response=httpClient.get(Request.Browse.FeaturedPlaylist(
            country = "NG",
            locale = "yo_NG",
            limit = "10",
            offset = "0"
        ))

        val feature:Feature=if(response.status== HttpStatusCode.OK){
            response.body()
        }else{
            val message:Message=response.body()
            throw Exception(message.error.message)
        }

        return feature.playlists
    }

    override suspend fun getNewRelease(): Albums {
        val response=httpClient.get(
        Request.Browse.NewReleases(
            limit = "10",
            country = "NG",
            offset = "0"
        )
        )
        val newRelease: NetworkAlbums = if (response.status== HttpStatusCode.OK){
            response.body()
        }else{
            val message:Message=response.body()
            throw Exception(message.error.message)
        }
        return newRelease.albums
    }

    override suspend fun getRelatedArtists(): List<NetworkArtist> {
        val response=httpClient.get(Request.Artist.Id.RelatedArtists(
            Request.Artist.Id(id="1E5hfn5BduN2nnoZCJmUVG")))

        val relatedArtists: RelatedArtists=if(response.status==HttpStatusCode.OK){
            response.body()
        }else{
            val message:Message=response.body()
            throw Exception(message.error.message)
        }
        return relatedArtists.artists
    }

    override suspend fun search(query: String, type: String): List<NetworkTrack> {
       val response=httpClient.get(Request.Search(q=query, type = type, offset = "0", limit = "10"))

        val netWorkTracks: Search= if (response.status== HttpStatusCode.OK){
            response.body()
        }else
        {
            val message :Message=response.body()
            throw Exception(message.error.message)
        }


        return netWorkTracks.tracks.items
    }

}







