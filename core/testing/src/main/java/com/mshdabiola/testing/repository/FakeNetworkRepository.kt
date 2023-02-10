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
                    artist = "Corri",
                    duration = 4063,
                    image = "Jantzen",
                    previewUri = "Casaundra",
                    type = "Osman", releaseDate = 1442L
                ),
                Track(
                    id = "Lamonica",
                    name = "Ross",
                    artist = "Dionte",
                    duration = 9541,
                    image = "Bobbijo",
                    previewUri = "Jona",
                    type = "Seanna", releaseDate = 9864L
                ),
                Track(
                    id = "Delores",
                    name = "Monica",
                    artist = "Mandi",
                    duration = 7739,
                    image = "Rayna",
                    previewUri = "Ericca",
                    type = "Devin", releaseDate = 527L
                ),
                Track(
                    id = "Reilly",
                    name = "Manuela",
                    artist = "Shaylee",
                    duration = 3524,
                    image = "Erich",
                    previewUri = "Shekia",
                    type = "Terah", releaseDate = 527L
                ),
                Track(
                    id = "Jacky",
                    name = "Tyree",
                    artist = "Cora",
                    duration = 209,
                    image = "Axel",
                    previewUri = "Shalina",
                    type = "Indra", releaseDate = 527L
                ),
                Track(
                    id = "Basilio",
                    name = "Linda",
                    artist = "Kasheena",
                    duration = 3678,
                    image = "Valeen",
                    previewUri = "Richele",
                    type = "Joleen", releaseDate = 527L
                ),
                Track(
                    id = "Tomika",
                    name = "Lorien",
                    artist = "Jonita",
                    duration = 6679,
                    image = "Nils",
                    previewUri = "Valeria",
                    type = "Dagoberto", releaseDate = 527L
                ),
                Track(
                    id = "Rafeal",
                    name = "Deontae",
                    artist = "Margo",
                    duration = 2519,
                    image = "Jahmel",
                    previewUri = "Homer",
                    type = "Maximillian", releaseDate = 527L
                ),
                Track(
                    id = "Shifra",
                    name = "Arminda",
                    artist = "Tito",
                    duration = 3595,
                    image = "Krystan",
                    previewUri = "Ieasha",
                    type = "Jenee", releaseDate = 527L
                ),
                Track(
                    id = "Serge",
                    name = "Tanya",
                    artist = "Ismail",
                    duration = 526,
                    image = "Appollonia",
                    previewUri = "Capri",
                    type = "Montel", releaseDate = 527L
                ),
                Track(
                    id = "Judith",
                    name = "Jamaine",
                    artist = "Randi",
                    duration = 4473,
                    image = "Porchia",
                    previewUri = "Sidra",
                    type = "Shemika", releaseDate = 527L
                ),
                Track(
                    id = "Gabriela",
                    name = "Raheem",
                    artist = "Janette",
                    duration = 4705,
                    image = "Zenia",
                    previewUri = "Rodney",
                    type = "Spring", releaseDate = 527L
                )
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
                    artist = "Corri",
                    duration = 4063,
                    image = "Jantzen",
                    previewUri = "Casaundra",
                    type = "Osman", releaseDate = 527L
                ),
                Track(
                    id = "Lamonica",
                    name = "Ross",
                    artist = "Dionte",
                    duration = 9541,
                    image = "Bobbijo",
                    previewUri = "Jona",
                    type = "Seanna", releaseDate = 527L
                ),
                Track(
                    id = "Delores",
                    name = "Monica",
                    artist = "Mandi",
                    duration = 7739,
                    image = "Rayna",
                    previewUri = "Ericca",
                    type = "Devin", releaseDate = 527L
                ),
                Track(
                    id = "Reilly",
                    name = "Manuela",
                    artist = "Shaylee",
                    duration = 3524,
                    image = "Erich",
                    previewUri = "Shekia",
                    type = "Terah", releaseDate = 527L
                ),
                Track(
                    id = "Jacky",
                    name = "Tyree",
                    artist = "Cora",
                    duration = 209,
                    image = "Axel",
                    previewUri = "Shalina",
                    type = "Indra", releaseDate = 527L
                ),
                Track(
                    id = "Basilio",
                    name = "Linda",
                    artist = "Kasheena",
                    duration = 3678,
                    image = "Valeen",
                    previewUri = "Richele",
                    type = "Joleen", releaseDate = 527L
                ),
                Track(
                    id = "Tomika",
                    name = "Lorien",
                    artist = "Jonita",
                    duration = 6679,
                    image = "Nils",
                    previewUri = "Valeria",
                    type = "Dagoberto", releaseDate = 527L
                ),
                Track(
                    id = "Rafeal",
                    name = "Deontae",
                    artist = "Margo",
                    duration = 2519,
                    image = "Jahmel",
                    previewUri = "Homer",
                    type = "Maximillian", releaseDate = 527L
                ),
                Track(
                    id = "Shifra",
                    name = "Arminda",
                    artist = "Tito",
                    duration = 3595,
                    image = "Krystan",
                    previewUri = "Ieasha",
                    type = "Jenee", releaseDate = 527L
                ),
                Track(
                    id = "Serge",
                    name = "Tanya",
                    artist = "Ismail",
                    duration = 526,
                    image = "Appollonia",
                    previewUri = "Capri",
                    type = "Montel", releaseDate = 527L
                ),
                Track(
                    id = "Judith",
                    name = "Jamaine",
                    artist = "Randi",
                    duration = 4473,
                    image = "Porchia",
                    previewUri = "Sidra",
                    type = "Shemika", releaseDate = 527L
                ),
                Track(
                    id = "Gabriela",
                    name = "Raheem",
                    artist = "Janette",
                    duration = 4705,
                    image = "Zenia",
                    previewUri = "Rodney",
                    type = "Spring", releaseDate = 527L
                )
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
                artist = "Katharina",
                imageUri = "Dajuan", tracks = listOf()
            ),
            Album(
                id = "Cindy",
                name = "Mallori",
                releaseDate = 0,
                albumType = "Dontrell",
                type = "Marlen",
                artist = "Julietta",
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
                artist = "Katharina",
                imageUri = "Dajuan", tracks = listOf()
            ),
            Album(
                id = "Cindy",
                name = "Mallori",
                releaseDate = 89,
                albumType = "Dontrell",
                type = "Marlen",
                artist = "Julietta",
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
                    artist = "Corri",
                    duration = 4063,
                    image = "Jantzen",
                    previewUri = "Casaundra",
                    type = "Osman", releaseDate = 5338L
                ),
                Track(
                    id = "Lamonica",
                    name = "Ross",
                    artist = "Dionte",
                    duration = 9541,
                    image = "Bobbijo",
                    previewUri = "Jona",
                    type = "Seanna", releaseDate = 9864L
                ),
                Track(
                    id = "Delores",
                    name = "Monica",
                    artist = "Mandi",
                    duration = 7739,
                    image = "Rayna",
                    previewUri = "Ericca",
                    type = "Devin", releaseDate = 527L
                ),
                Track(
                    id = "Reilly",
                    name = "Manuela",
                    artist = "Shaylee",
                    duration = 3524,
                    image = "Erich",
                    previewUri = "Shekia",
                    type = "Terah", releaseDate = 527L
                ),
                Track(
                    id = "Jacky",
                    name = "Tyree",
                    artist = "Cora",
                    duration = 209,
                    image = "Axel",
                    previewUri = "Shalina",
                    type = "Indra", releaseDate = 527L
                ),
                Track(
                    id = "Basilio",
                    name = "Linda",
                    artist = "Kasheena",
                    duration = 3678,
                    image = "Valeen",
                    previewUri = "Richele",
                    type = "Joleen", releaseDate = 527L
                ),
                Track(
                    id = "Tomika",
                    name = "Lorien",
                    artist = "Jonita",
                    duration = 6679,
                    image = "Nils",
                    previewUri = "Valeria",
                    type = "Dagoberto", releaseDate = 527L
                ),
                Track(
                    id = "Rafeal",
                    name = "Deontae",
                    artist = "Margo",
                    duration = 2519,
                    image = "Jahmel",
                    previewUri = "Homer",
                    type = "Maximillian", releaseDate = 527L
                ),
                Track(
                    id = "Shifra",
                    name = "Arminda",
                    artist = "Tito",
                    duration = 3595,
                    image = "Krystan",
                    previewUri = "Ieasha",
                    type = "Jenee", releaseDate = 527L
                ),
                Track(
                    id = "Serge",
                    name = "Tanya",
                    artist = "Ismail",
                    duration = 526,
                    image = "Appollonia",
                    previewUri = "Capri",
                    type = "Montel", releaseDate = 527L
                ),
                Track(
                    id = "Judith",
                    name = "Jamaine",
                    artist = "Randi",
                    duration = 4473,
                    image = "Porchia",
                    previewUri = "Sidra",
                    type = "Shemika", releaseDate = 527L
                ),
                Track(
                    id = "Gabriela",
                    name = "Raheem",
                    artist = "Janette",
                    duration = 4705,
                    image = "Zenia",
                    previewUri = "Rodney",
                    type = "Spring", releaseDate = 527L
                )
            )
        )
    }

    override suspend fun getTrack(id: String): Result<Track> {
        return Result.success(
            Track(
                id = "Yalitza",
                name = "Nadir",
                artist = "Jamelle",
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
                artist = "Marylou",
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