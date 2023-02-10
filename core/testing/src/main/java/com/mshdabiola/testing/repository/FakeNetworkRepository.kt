package com.mshdabiola.testing.repository

import com.mshdabiola.data.repository.NetworkRepository
import com.mshdabiola.model.Album
import com.mshdabiola.model.Artist
import com.mshdabiola.model.Category
import com.mshdabiola.model.Playlist
import com.mshdabiola.model.Track

class FakeNetworkRepository : NetworkRepository {
    override suspend fun getRecommendation(): Result<List<Track>> {
        return Result.success(
            listOf(
                Track(
                    id = "Cherrelle",
                    name = "Cheryl",
                    artist = listOf(),
                    duration = 4063,
                    image = "Jantzen",
                    previewUri = "Casaundra",
                    type = "Osman", releaseDate = 1442L
                ),
                Track(
                    id = "Lamonica",
                    name = "Ross",
                    artist = listOf(),
                    duration = 9541,
                    image = "Bobbijo",
                    previewUri = "Jona",
                    type = "Seanna", releaseDate = 9864L
                ),

            )
        )

    }

    override suspend fun getFeaturePlaylist(): Result<List<Playlist>> {
        return Result.success(listOf(
            Playlist(id = "1", name = "Montoya", description = "Colin", image = "Susanne"),
            Playlist(id = "2", name = "Josey", description = "Karra", image = "Romeo")
        ))
    }

    override suspend fun getCategory(): Result<List<Category>> {
        return Result.success(listOf(
            Category(name = "Deyanira", id = "Titus", image = "Karlyn"),
            Category(name = "Emerald", id = "Ezekiel", image = "Avi")
        ))
    }

    override suspend fun getArtiste(): Result<List<Artist>> {
       return Result.success( listOf(
           Artist(id = "Ernestine", name = "Wardell", image = "Ashlie", type = "Samara"),
           Artist(id = "Hanif", name = "Kai", image = "Lance", type = "Lashonda")
       ))

    }

    override suspend fun search(query: String, type: String): Result<List<Track>> {
        return Result.success(
            listOf(
                Track(
                    id = "Cherrelle",
                    name = "Cheryl",
                    artist = listOf(),
                    duration = 4063,
                    image = "Jantzen",
                    previewUri = "Casaundra",
                    type = "Osman", releaseDate = 527L
                ),
                Track(
                    id = "Lamonica",
                    name = "Ross",
                    artist = listOf(),
                    duration = 9541,
                    image = "Bobbijo",
                    previewUri = "Jona",
                    type = "Seanna", releaseDate = 527L
                ),

            )
        )
    }

    override suspend fun getNewRelease(): Result<List<Album>> {
        return Result.success(listOf(
            Album(
                id = "Loyd",
                name = "Soloman",
                releaseDate = 0,
                albumType = "Shontay",
                type = "Travon",
                artist = listOf(),
                imageUri = "Dajuan", tracks = listOf()
            ),
            Album(
                id = "Cindy",
                name = "Mallori",
                releaseDate = 0,
                albumType = "Dontrell",
                type = "Marlen",
                artist = listOf(),
                imageUri = "Alon", tracks = listOf()
            )
        ))
    }

    override suspend fun getUserAlbums(): Result<List<Album>> {
        return Result.success(listOf(
            Album(
                id = "Loyd",
                name = "Soloman",
                releaseDate = 78,
                albumType = "Shontay",
                type = "Travon",
                artist = listOf(),
                imageUri = "Dajuan", tracks = listOf()
            ),
            Album(
                id = "Cindy",
                name = "Mallori",
                releaseDate = 89,
                albumType = "Dontrell",
                type = "Marlen",
                artist = listOf(),
                imageUri = "Alon", tracks = listOf()
            )
        ))
    }

    override suspend fun getUserTracks(): Result<List<Track>> {
        return Result.success(
            listOf(
                Track(
                    id = "Cherrelle",
                    name = "Cheryl",
                    artist = listOf(),
                    duration = 4063,
                    image = "Jantzen",
                    previewUri = "Casaundra",
                    type = "Osman", releaseDate = 5338L
                ),
                Track(
                    id = "Lamonica",
                    name = "Ross",
                    artist = listOf(),
                    duration = 9541,
                    image = "Bobbijo",
                    previewUri = "Jona",
                    type = "Seanna", releaseDate = 9864L
                ),
                Track(
                    id = "Delores",
                    name = "Monica",
                    artist = listOf(),
                    duration = 7739,
                    image = "Rayna",
                    previewUri = "Ericca",
                    type = "Devin", releaseDate = 527L
                ),

            )
        )
    }

    override suspend fun getTrack(id: String): Result<Track> {
        return Result.success(
            Track(
                id = "Yalitza",
                name = "Nadir",
                artist =listOf(),
                duration = 4872,
                image = "Vincenzo",
                previewUri = "Sophia",
                type = "Steffani", releaseDate = 527L
            )
        )
    }

    override suspend fun getAlbum(id: String): Result<Album> {
        return Result.success(
            Album(
                id = "Miquel",
                name = "Aliesha",
                releaseDate =89,
                albumType = "Eliyahu",
                type = "Amee",
                artist = listOf(),
                imageUri = "Ali", tracks = listOf(),
            )
        )

    }

    override suspend fun getPlaylist(id: String): Result<Playlist> {
        return Result.success(
            Playlist(id = "Cinthia", name = "Ashia", description = "Yee", image = "Marley")
        )

    }

    override suspend fun getArtist(id: String): Result<Artist> {
        return Result.success(
            Artist(id = "Meera", name = "Rondale", image = "Zandra", type = "Bruno")
        )

    }
}