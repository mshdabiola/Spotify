package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Album(
	val images: List<ImagesItem>,
	val type: String,
	val releaseDate: String?=null,
	val artists: List<ArtistsItem>,
	val name: String,
	val albumType: String?=null,
	val id: String,
)
