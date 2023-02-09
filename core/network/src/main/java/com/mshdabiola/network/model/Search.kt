package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.NetworkTracks
import kotlinx.serialization.Serializable

@Serializable
data class Search(
	val tracks: NetworkTracks
)
