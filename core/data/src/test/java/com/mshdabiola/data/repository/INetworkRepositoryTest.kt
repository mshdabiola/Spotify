package com.mshdabiola.data.repository

import com.mshdabiola.network.fake.FakeNetworkDataSource
import com.mshdabiola.testing.repository.FakeNetworkRepository
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
        networkRepository=INetworkRepository(networkDataSource = FakeNetworkDataSource())
    }

    @Test
    fun getRecommendation()= runTest {
       val tracks=  networkRepository.getRecommendation()
        assertEquals(10,tracks.size)
    }

    @Test
    fun getFeaturePlaylist() = runTest {
        val playlists=networkRepository.getFeaturePlaylist()
        assertEquals(2,playlists.size)
    }

    @Test
    fun getCategory() = runTest {
        val categories=networkRepository.getCategory()
        assertEquals(20,categories.size)
    }

    @Test
    fun getArtiste() = runTest {
        val artist=networkRepository.getArtiste()
        assertEquals(0,artist.size)
    }

    @Test
    fun getNewRelease() = runTest {
        val album = networkRepository.getNewRelease()
        assertEquals(20,album.size)
    }
}