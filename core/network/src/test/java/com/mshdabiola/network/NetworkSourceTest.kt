package com.mshdabiola.network

import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.http.headersOf
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File

class NetworkSourceTest {
 private lateinit var networkSource: NetworkSource
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
                else->""
            }

            respond(
                content = ByteReadChannel(File("$path/$name.json").readText()),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json"),
            )
        }
        val client = Client.get(engine)
        networkSource = NetworkSource(client)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getRecommendation() = runTest{
        val recommendations=networkSource.getRecommendation()

        assertEquals(10, recommendations.tracks.size)
    }

    @Test
    fun getCategory() = runTest{
        val category=networkSource.getCategory()
        assert(category.icons?.isNotEmpty() ?:false)
    }

    @Test
    fun getPlaylist() {
    }

    @Test
    fun getFeaturePlaylist() {
    }

    @Test
    fun getNewRelease() = runTest{
        val newRelease=networkSource.getNewRelease()
        assert(newRelease.albums?.items?.isNotEmpty() ?:false)
    }
}