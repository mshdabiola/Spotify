package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Album(
	val images: List<Image> ,
	val artists: List<Artist>,
	val name: String,
	val type: String,
	val id: String,
)
