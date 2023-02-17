package com.mshdabiola.data.repository

import com.mshdabiola.network.fake.FakeNetworkDataSource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class INetworkRepositoryTest {

    private lateinit var networkRepository: NetworkRepository

    @Before
    fun setUp() {
        networkRepository = INetworkRepository(networkDataSource = FakeNetworkDataSource())
    }

    @Test
    fun getRecommendation() = runTest {
        val tracks = networkRepository.getRecommendation()
        assertEquals(10, tracks.getOrNull()!!.size)
    }

    @Test
    fun getFeaturePlaylist() = runTest {
        val playlists = networkRepository.getFeaturePlaylist()
        assertEquals(2, playlists.getOrNull()!!.size)
    }

    @Test
    fun getCategory() = runTest {
        val categories = networkRepository.getCategory()
        assertEquals(20, categories.getOrNull()!!.size)
    }

    @Test
    fun getArtiste() = runTest {
        val artist = networkRepository.getArtiste()
        assertEquals(20, artist.getOrNull()!!.size)
    }

    @Test
    fun getNewRelease() = runTest {
        val album = networkRepository.getNewRelease()
        assertEquals(20, album.getOrNull()!!.size)
    }

    @Test
    fun search() = runTest {
        val tracks = networkRepository.search("wo", "ei")

        assertEquals(10, tracks.getOrNull()?.size)
    }

    @Test
    fun getUserAlbums() = runTest {
        val album = networkRepository.getUserAlbums()
        assertEquals(2, album.getOrNull()!!.size)
    }

    @Test
    fun getUserTracks() = runTest {
        val tracks = networkRepository.getUserTracks()
        assertEquals(2, tracks.getOrNull()!!.size)
    }

    @Test
    fun getTrack() = runTest {
        val track = networkRepository.getTrack("iie")
        assertEquals("11dFghVXANMlKmJXsNCbNl", track.getOrNull()?.id)
    }

    @Test
    fun getAlbum() = runTest {
        val album = networkRepository.getAlbum("iie")
        assertEquals("4aawyAB9vmqN3uQ7FjRGTy", album.getOrNull()?.id)
    }

    @Test
    fun getPlaylist() = runTest {
        val playlists = networkRepository.getPlaylist("iie")
        assertEquals("3cEYpjA9oz9GiPac4AsH4n", playlists.getOrNull()?.id)
    }

    @Test
    fun getArtist() = runTest {
        val artist = networkRepository.getArtist("iie")
        assertEquals("0TnOYISbd1XYRBk9myaseg", artist.getOrNull()?.id)
    }
}