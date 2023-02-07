package com.mshdabiola.network.model

import kotlinx.serialization.Serializable

@Serializable
data class FPlaylist(
	val playlists: Playlists,
	val message: String
)
