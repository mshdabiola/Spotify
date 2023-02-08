package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class NetworkTrack(
    val album: NetworkAlbum,
    val type: String,
    val durationMs: Int?=null,
    val isPlayable: Boolean?=null,
    val artists: List<NetworkArtistsItem>,
    val previewUrl: String?=null,
    val name: String,
    val href: String,
    val id: String,
)