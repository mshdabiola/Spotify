package com.mshdabiola.network

import com.mshdabiola.network.model.NewRelease
import com.mshdabiola.network.model.Recommendation
import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Playlists
import com.mshdabiola.network.model.comp.Track
import com.mshdabiola.network.model.comp.Tracks
import com.mshdabiola.network.request.Request
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.resources.get
import javax.inject.Inject

class INetworkDataSource @Inject constructor(
    private val httpClient: HttpClient,
) : NetworkDataSource {

    override suspend fun getRecommendation(): List<Track> {
        val recommendation: Recommendation = httpClient.get(
            Request.Recommendations(
                limit = "10",
                market = "NG",
                seed_artists = "4NHQUGzhtTLFvgF5SZesLK",
                seed_genres = "classical",
                seed_tracks = "0c6xIDDpzE81m2q797ordA"
            )
        ).body()

        return recommendation.tracks
    }

    override suspend fun getCategory(): Categories {
        return httpClient.get(Request.Browse.Category()).body()
    }


    override suspend fun getFeaturePlaylist(): Playlists {
        return httpClient.get(Request.Browse.FeaturedPlaylist()).body()
    }

    override suspend fun getNewRelease(): Albums {
        val newRelease: NewRelease = httpClient.get(
            Request.Browse.NewReleases(
                limit = "",
                country = "NG",
                offset = "0"
            )
        ).body()
        return newRelease.albums
    }
}







