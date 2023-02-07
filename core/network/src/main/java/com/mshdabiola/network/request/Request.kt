package com.mshdabiola.network.request

import io.ktor.resources.Resource

@Resource("v1")
class Request {

    @Resource("browse")
    class Browse(val request: Request= Request()) {
        @Resource("categories")
        class Category(val browse: Browse= Browse())

        @Resource("featured-playlists")
        class FeaturedPlaylist(
            val browse: Browse = Browse(),
            val country: String = "NG"
        )

        @Resource("new-releases")
        class NewReleases(val browse: Browse=Browse())
    }
    @Resource("recommendations")
    class Recommendations(
        val request: Request = Request(),
        val limit: String = "10",
        val market: String = "NG",
        val seed_artists: String = "4NHQUGzhtTLFvgF5SZesLK",
        val seed_genres: String = "classical",
        val seed_tracks: String = "0c6xIDDpzE81m2q797ordA"
    )
}