package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class NetworkCategory(
	val name: String,
	val id: String,
	val icons: List<ImagesItem>
)
