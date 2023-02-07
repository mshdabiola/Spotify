package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
	val images: List<ImagesItem>,
	val description: String,
	val type: String,
	val tracks: Tracks,
	val name: String,
	val id: String,
)
