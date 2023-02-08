package com.mshdabiola.data.repository

import com.mshdabiola.data.model.asAlbum
import com.mshdabiola.data.model.asCategory
import com.mshdabiola.data.model.asPlaylist
import com.mshdabiola.data.model.asTrack
import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track
import com.mshdabiola.network.NetworkDataSource
import javax.inject.Inject

class INetworkRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : NetworkRepository {
    override suspend fun getRecommendation(): List<Track> {
        return networkDataSource.getRecommendation().map { it.asTrack() }
    }

    override suspend fun getFeaturePlaylist(): List<Playlist> {
        return networkDataSource.getFeaturePlaylist().items.map { it.asPlaylist() }
    }

    override suspend fun getCategory(): List<Category> {
        return networkDataSource.getCategory().items.map { it.asCategory() }
    }

    override suspend fun getArtiste(): List<Artist> {
        //return networkDataSource.
        return emptyList()
    }

    override suspend fun getNewRelease(): List<Album> {
        return networkDataSource.getNewRelease().items.map { it.asAlbum() }
    }

}
