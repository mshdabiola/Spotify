package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class RelatedArtists(
	val artists: List<NetworkArtist>
)
