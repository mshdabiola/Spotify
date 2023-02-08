package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class NetworkArtist(
	val images: List<ImagesItem>,
	val name: String,
	val id: String,
	val type: String,
	val uri: String
)
