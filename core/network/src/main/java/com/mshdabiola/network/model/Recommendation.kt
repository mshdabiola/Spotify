package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.Seed
import com.mshdabiola.network.model.comp.NetworkTrack
import kotlinx.serialization.Serializable

@Serializable
data class Recommendation(
	val seeds: List<Seed>,
	val tracks: List<NetworkTrack>
)
