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
        class NewReleases(
            val browse: Browse = Browse(),
            val country: String,
            val limit: String,
            val offset: String
        )
    }
    @Resource("recommendations")
    class Recommendations(
        val request: Request = Request(),
        val limit: String,
        val market: String,
        val seed_artists: String,
        val seed_genres: String,
        val seed_tracks: String
    )
}