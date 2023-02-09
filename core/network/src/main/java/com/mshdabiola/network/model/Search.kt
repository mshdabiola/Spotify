package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.NetworkTracks2
import kotlinx.serialization.Serializable

@Serializable
data class Search(
	val tracks: NetworkTracks2
)
