package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class NetworkTracks(
    val next: String? = null,
    val total: Int? = null,
    val offset: Int? = null,
    val previous: String? = null,
    val limit: Int? = null,
    val href: String? = null,
    val items: List<NetworkTrack>
)
