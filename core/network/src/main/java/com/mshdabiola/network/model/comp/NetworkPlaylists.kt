package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPlaylists(
    val next: String? = null,
    val total: Int,
    val offset: Int,
    val previous: String? = null,
    val limit: Int,
    val href: String,
    val items: List<NetworkPlaylist>
)
