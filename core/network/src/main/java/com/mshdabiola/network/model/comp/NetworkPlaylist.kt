package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPlaylist(
	val images: List<ImagesItem>,
	val description: String,
	val type: String,
	//val networkTracks: NetworkTracks,
	val name: String,
	val id: String,
)
