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
    override suspend fun getRecommendation(): Result<List<Track>> {
        return try {
           Result.success(networkDataSource.getRecommendation().map { it.asTrack() })
        }catch (e : Exception){
            Result.failure(e)
        }

    }

    override suspend fun getFeaturePlaylist(): Result<List<Playlist>> {
        return try {
            Result.success(networkDataSource.getFeaturePlaylist().items.map { it.asPlaylist() })
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun getCategory(): Result<List<Category>> {
        return try {
            Result.success( networkDataSource.getCategory().items.map { it.asCategory() })
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun getArtiste(): Result<List<Artist>> {
        //return networkDataSource.
        return try {
            Result.success(emptyList())
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun getNewRelease(): Result<List<Album>> {
        return try {
            Result.success(networkDataSource.getNewRelease().items.map { it.asAlbum() })
        }catch (e : Exception){
            Result.failure(e)
        }

    }

}
