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
                    type = "Osman"
                ),
                Track(
                    id = "Lamonica",
                    name = "Ross",
                    artist = "Dionte",
                    duration = 9541,
                    image = "Bobbijo",
                    previewUri = "Jona",
                    type = "Seanna"
                ),
                Track(
                    id = "Delores",
                    name = "Monica",
                    artist = "Mandi",
                    duration = 7739,
                    image = "Rayna",
                    previewUri = "Ericca",
                    type = "Devin"
                ),
                Track(
                    id = "Reilly",
                    name = "Manuela",
                    artist = "Shaylee",
                    duration = 3524,
                    image = "Erich",
                    previewUri = "Shekia",
                    type = "Terah"
                ),
                Track(
                    id = "Jacky",
                    name = "Tyree",
                    artist = "Cora",
                    duration = 209,
                    image = "Axel",
                    previewUri = "Shalina",
                    type = "Indra"
                ),
                Track(
                    id = "Basilio",
                    name = "Linda",
                    artist = "Kasheena",
                    duration = 3678,
                    image = "Valeen",
                    previewUri = "Richele",
                    type = "Joleen"
                ),
                Track(
                    id = "Tomika",
                    name = "Lorien",
                    artist = "Jonita",
                    duration = 6679,
                    image = "Nils",
                    previewUri = "Valeria",
                    type = "Dagoberto"
                ),
                Track(
                    id = "Rafeal",
                    name = "Deontae",
                    artist = "Margo",
                    duration = 2519,
                    image = "Jahmel",
                    previewUri = "Homer",
                    type = "Maximillian"
                ),
                Track(
                    id = "Shifra",
                    name = "Arminda",
                    artist = "Tito",
                    duration = 3595,
                    image = "Krystan",
                    previewUri = "Ieasha",
                    type = "Jenee"
                ),
                Track(
                    id = "Serge",
                    name = "Tanya",
                    artist = "Ismail",
                    duration = 526,
                    image = "Appollonia",
                    previewUri = "Capri",
                    type = "Montel"
                ),
                Track(
                    id = "Judith",
                    name = "Jamaine",
                    artist = "Randi",
                    duration = 4473,
                    image = "Porchia",
                    previewUri = "Sidra",
                    type = "Shemika"
                ),
                Track(
                    id = "Gabriela",
                    name = "Raheem",
                    artist = "Janette",
                    duration = 4705,
                    image = "Zenia",
                    previewUri = "Rodney",
                    type = "Spring"
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

    override suspend fun getNewRelease(): Result<List<Album>> {
        return Result.success(listOf(
            Album(
                id = "Loyd",
                name = "Soloman",
                releaseDate = "Ainsley",
                albumType = "Shontay",
                type = "Travon",
                artist = "Katharina",
                imageUri = "Dajuan"
            ),
            Album(
                id = "Cindy",
                name = "Mallori",
                releaseDate = "Jennalee",
                albumType = "Dontrell",
                type = "Marlen",
                artist = "Julietta",
                imageUri = "Alon"
            )
        ))
    }
}