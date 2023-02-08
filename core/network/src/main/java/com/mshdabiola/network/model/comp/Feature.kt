package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Feature(
	val playlists: NetworkPlaylists,
	val message: String
)
