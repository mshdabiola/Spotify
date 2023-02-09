package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.NetworkTrack
import kotlinx.serialization.Serializable

@Serializable
data class NetWorkTracks(
//	val seeds: List<Seed>,
	val tracks: List<NetworkTrack>
)
