package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.NetworkTrack
import kotlinx.serialization.Serializable

@Serializable
data class PagingNetWorkTracks(
    val tracks: List<NetworkTrack>
)
