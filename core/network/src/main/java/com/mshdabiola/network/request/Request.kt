package com.mshdabiola.network.request

import io.ktor.resources.Resource

@Resource("v1")
class Request {

    @Resource("browse")
    class Browse(val request: Request = Request()) {
        @Resource("categories")
        class Category(
            val browse: Browse = Browse(),
            val country: String,
            val locale: String,
            val limit: String,
            val offset: String,
        )

        @Resource("featured-playlists")
        class FeaturedPlaylist(
            val browse: Browse = Browse(),
            val country: String,
            val locale: String,
            val limit: String,
            val offset: String,
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

    @Resource("artists")
    class Artist(val request: Request = Request()) {
        @Resource("{id}")
        class Id(val artist: Artist = Artist(), val id: String) {
            @Resource("related-artists")
            class RelatedArtists(val id: Id)
        }
    }

    @Resource("search")
    class Search(
        val request: Request = Request(),
        val q: String,
        val type: String,
        val offset: String,
        val limit: String
    )

    @Resource("me")
    class Me(val request: Request = Request()) {
        @Resource("albums")
        class Album(val me: Me = Me())

        @Resource("tracks")
        class Tracks(val me: Me = Me())
    }

    @Resource("albums")
    class Albums(val request: Request = Request()) {
        @Resource("{id}")
        class Id(val albums: Albums = Albums(), val id: String)
    }

    @Resource("tracks")
    class Tracks(val request: Request = Request()) {
        @Resource("{id}")
        class Id(val albums: Tracks = Tracks(), val id: String)
    }

    @Resource("playlists")
    class Playlists(val request: Request = Request()) {
        @Resource("{id}")
        class Id(val playlists: Playlists = Playlists(), val id: String)
    }
}