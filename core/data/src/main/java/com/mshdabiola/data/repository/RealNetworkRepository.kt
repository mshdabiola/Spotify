package com.mshdabiola.data.repository

import com.mshdabiola.data.model.toAlbum
import com.mshdabiola.data.model.toTrack
import com.mshdabiola.model.Album
import com.mshdabiola.network.NetworkSource
import com.mshdabiola.network.toCustomExceptions
import javax.inject.Inject

class RealNetworkRepository @Inject constructor(
    private val networkSource: NetworkSource,
) : NetworkRepository {
    override suspend fun get() {

    }

    override suspend fun recommendation():Result<List<Album>>{
        return try {

           Result.success(networkSource.getRecommendation().tracks.map { it.album.toTrack() })
        }catch (e : Exception){
            Result.failure(e.toCustomExceptions())
        }
    }

    override suspend fun newRelease(): Result<List<Album>>{
        return try {
            val newRelease= networkSource.getNewRelease().albums.items.map { it .toTrack() }
            Result.success(newRelease)//newRelease ?: emptyList()

        }catch (e:Exception){
           // e.printStackTrace()
            Result.failure(e.toCustomExceptions())
        }

    }
}
