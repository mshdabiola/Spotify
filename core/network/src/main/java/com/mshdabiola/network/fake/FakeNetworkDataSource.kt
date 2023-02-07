package com.mshdabiola.network.fake

import com.mshdabiola.network.NetworkDataSource
import com.mshdabiola.network.model.NewRelease
import com.mshdabiola.network.model.comp.Albums
import com.mshdabiola.network.model.comp.Categories
import com.mshdabiola.network.model.comp.Playlists
import com.mshdabiola.network.model.comp.Track
import com.mshdabiola.network.model.comp.Tracks

class FakeNetworkDataSource : NetworkDataSource {
    override suspend fun getRecommendation(): List<Track> {
        TODO("Not yet implemented")
    }

    override suspend fun getCategory(): Categories {
        TODO("Not yet implemented")
    }

    override suspend fun getFeaturePlaylist(): Playlists {
        TODO("Not yet implemented")
    }

    override suspend fun getNewRelease(): Albums {
        TODO("Not yet implemented")
    }

}