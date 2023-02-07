package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Album(
	val images: List<ImagesItem>,
	val label: String,
	val type: String,
	val releaseDate: String,
	val artists: List<Artist>,
	val name: String,
	val albumType: String,
	val id: String,
)
