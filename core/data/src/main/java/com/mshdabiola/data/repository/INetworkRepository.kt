package com.mshdabiola.data.repository

import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track
import com.mshdabiola.network.NetworkDataSource
import javax.inject.Inject

class INetworkRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
) : NetworkRepository {
    override suspend fun recommendation(): Result<List<Track>> {
        TODO("Not yet implemented")
    }

    override suspend fun newRelease(): Result<List<Album>> {
        TODO("Not yet implemented")
    }

    override suspend fun featurePlaylist(): Result<List<Playlist>> {
        TODO("Not yet implemented")
    }

    override suspend fun getArtiste(): Result<List<Artist>> {
        TODO("Not yet implemented")
    }

}
