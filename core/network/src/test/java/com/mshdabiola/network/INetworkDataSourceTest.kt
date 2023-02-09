package com.mshdabiola.network

import com.mshdabiola.network.fake.FakeNetworkDataSource
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

@OptIn(ExperimentalCoroutinesApi::class)
class INetworkDataSourceTest {
    private lateinit var networkDataSource: NetworkDataSource
    private val path="/Users/user/AndroidStudioProjects/Spotify/data/"
    @Before
    fun setUp() {

        val engine = MockEngine() { re ->
            val name=when{
                re.url.encodedPath.contains("available")-> "available_genre"
                re.url.encodedPath.contains("recommendations")-> "recommendations"
                re.url.encodedPath.contains("new")-> "new_release"
                re.url.encodedPath.contains("featured")-> "browse_featured_playlist"
                re.url.encodedPath.contains("playlist")-> "browse_category_id_playlist"
                re.url.encodedPath.contains("categories")-> "browse_category"
                re.url.encodedPath.contains("artists")->"artists"
                re.url.encodedPath.contains("search")->"search_track"
                re.url.encodedPath.contains("albums")->"user_album"
                re.url.encodedPath.contains("tracks")->"user_tracks"
                else->""
            }

            respond(
                content = ByteReadChannel(File("$path/$name.json").readText()),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
            )
        }
        val client = Client.get(engine)
        networkDataSource = INetworkDataSource(client)
    }
    @After
    fun tearDown() = runTest {
    }

    @Test
    fun getRecommendation() = runTest {

        val recommendation= networkDataSource.getRecommendation()

        assertEquals(10,recommendation.size)
    }

    @Test
    fun getCategory() = runTest {
    val categories= networkDataSource.getCategory()
        assertEquals(20,categories.items.size)
    }

    @Test
    fun getFeaturePlaylist() = runTest {
        val playlists= networkDataSource.getFeaturePlaylist()
        assertEquals(2,playlists.items.size)
    }

    @Test
    fun getNewRelease()= runTest {
        val newRelease=networkDataSource.getNewRelease()

        assertEquals(20,newRelease.items.size)
    }

    @Test
    fun getRelatedArtists()= runTest {
        val artists=networkDataSource.getRelatedArtists()
        assertEquals(20,artists.size)
    }

    @Test
    fun search()= runTest {
        val search= networkDataSource.search("wizkid","track")

        assertEquals(10,search.size)
    }

    @Test
    fun getUserAlbum() = runTest{
        val albums=networkDataSource.getUserAlbum()
//
        assertEquals(2,albums.size)
    }

    @Test
    fun getUserTracks()= runTest() {
        val tracks=networkDataSource.getUserTracks()
//
        assertEquals(2,tracks.size)
    }
}