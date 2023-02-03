package com.mshdabiola.network.request

import io.ktor.resources.Resource

@Resource("v1")
class Request {

    @Resource("browse")
    class Browse(val request: Request= Request()) {
        @Resource("categories")
        class Category(val browse: Browse= Browse()){

            @Resource("{id}")
            class Id(val category: Category= Category(), val id : String?=null){
                @Resource("playlists")
                class Playlist(val id: Id=Id())
            }
        }

        @Resource("featured-playlists")
        class FeaturedPlaylist(val browse: Browse= Browse())

        @Resource("new-releases")
        class NewReleases(val browse: Browse=Browse())
    }
    @Resource("recommendations")
    class Recommendations(val request: Request= Request(),val limit:String="10",val market:String="NG",val seed_artists:String="4NHQUGzhtTLFvgF5SZesLK",val seed_genres:String="classical",val seed_tracks:String="0c6xIDDpzE81m2q797ordA"){

        @Resource("available_genre_seeds")
        class AvailableGenre(val recommendations: Recommendations= Recommendations())
    }
}