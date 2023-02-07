package com.mshdabiola.network

import com.mshdabiola.network.model.Albums
import com.mshdabiola.network.model.Categories
import com.mshdabiola.network.model.Playlists
import com.mshdabiola.network.model.Tracks
import com.mshdabiola.network.request.Request
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import javax.inject.Inject

class INetworkDataSource @Inject constructor(
    private val httpClient: HttpClient,
) : NetworkDataSource {

    override suspend fun getRecommendation(): Tracks {
        return   httpClient.get(Request.Recommendations()).body()
    }

    override suspend fun getCategory():Categories{
        return  httpClient.get(Request.Browse.Category()).body()
    }


    override suspend fun getFeaturePlaylist():Playlists{
        return  httpClient.get(Request.Browse.FeaturedPlaylist()).body()
    }

    override suspend fun getNewRelease(): Albums {
        return httpClient.get(Request.Browse.NewReleases()).body()

    }
}







