package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.Seed
import com.mshdabiola.network.model.comp.Track
import kotlinx.serialization.Serializable

@Serializable
data class Recommendation(
	val seeds: List<Seed>,
	val tracks: List<Track>
)
