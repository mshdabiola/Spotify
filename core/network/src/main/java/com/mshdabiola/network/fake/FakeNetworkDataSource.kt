package com.mshdabiola.network.fake

import com.mshdabiola.network.NetworkDataSource
import com.mshdabiola.network.model.FPlaylist
import com.mshdabiola.network.model.NewRelease
import com.mshdabiola.network.model.Playlists
import com.mshdabiola.network.model.Recommendation
import com.mshdabiola.network.model.component.Category

class FakeNetworkDataSource : NetworkDataSource {
    override suspend fun getRecommendation(): Recommendation {
        TODO("Not yet implemented")
    }

    override suspend fun getCategory(): Category {
        TODO("Not yet implemented")
    }

    override suspend fun getPlaylist(id: String): Playlists {
        TODO("Not yet implemented")
    }

    override suspend fun getFeaturePlaylist(): FPlaylist {
        TODO("Not yet implemented")
    }

    override suspend fun getNewRelease(): NewRelease {
        TODO("Not yet implemented")
    }
}