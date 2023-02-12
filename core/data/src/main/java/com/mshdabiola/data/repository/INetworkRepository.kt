package com.mshdabiola.data.repository

import com.mshdabiola.data.model.asAlbum
import com.mshdabiola.data.model.asArtiste
import com.mshdabiola.data.model.asCategory
import com.mshdabiola.data.model.asPlaylist
import com.mshdabiola.data.model.asTrack
import com.mshdabiola.datastore.UserPreferenceDatasource
import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track
import com.mshdabiola.network.Config
import com.mshdabiola.network.NetworkDataSource
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class INetworkRepository @Inject constructor(
    private val networkDataSource: NetworkDataSource,
    private val userPreferenceDatasource: UserPreferenceDatasource
) : NetworkRepository {

    override suspend fun setUp() {
        Config.token=userPreferenceDatasource.userData.first().token
    }

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
            Result.success(networkDataSource.getRelatedArtists().map { it.asArtiste() })
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun search(query: String, type: String): Result<List<Track>> {
        return try {
            Result.success(networkDataSource.search(query, type).map { it.asTrack() })
        }catch (e:Exception){
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

    override suspend fun getUserAlbums(): Result<List<Album>> {
        return try {
            Result.success(networkDataSource.getUserAlbum().map { it.asAlbum() })
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun getUserTracks(): Result<List<Track>> {
        return try {
            Result.success(networkDataSource.getUserTracks().map { it.asTrack() })
        }catch (e : Exception){
            Result.failure(e)
        }
    }

    override suspend fun getTrack(id: String): Result<Track> {
        return try {
            Result.success(networkDataSource.getTrack(id).asTrack())
        }catch (e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun getAlbum(id: String): Result<Album> {
        return try {
            Result.success(networkDataSource.getAlbum(id).asAlbum())
        }catch (e:Exception){
            Result.failure(e)
        }
    }

    override suspend fun getPlaylist(id: String): Result<Playlist> {

            return try {
                val playlist=networkDataSource.getPlaylist(id)
                val play=Playlist(
                    playlist.id,
                    playlist.name,
                    playlist.description,
                    playlist.images.first().url,
                    playlist.tracks.items.map { it.track.asTrack() }
                    )
            Result.success(play)
        }catch (e:Exception){
            Result.failure(e)
        }

    }

    override suspend fun getArtist(id: String): Result<Artist> {
        return try {
            Result.success(networkDataSource.getArtist(id).asArtiste())
        }catch (e:Exception){
            Result.failure(e)
        }
    }


}
