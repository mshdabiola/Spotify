package com.mshdabiola.network.model.comp


import kotlinx.serialization.Serializable

@Serializable
data class NetworkAlbum(
    val images: List<ImagesItem>,
    val type: String,
    val releaseDate: String? = null,
    val artists: List<NetworkArtist>,
    val name: String,
    val albumType: String? = null,
    val id: String,
    val tracks: NetworkTracks? = null,
)
