package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class ArtistsItem(
	val name: String,
	val id: String,
)
