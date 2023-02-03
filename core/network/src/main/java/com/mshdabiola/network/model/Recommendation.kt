package com.mshdabiola.network.model

import com.mshdabiola.network.model.component.Album
import com.mshdabiola.network.model.component.Seed
import com.mshdabiola.network.model.component.Track
import kotlinx.serialization.Serializable

@Serializable
data class Recommendation(
	val seeds: List<Seed?>? = null,
	val tracks: List<Track>
)
