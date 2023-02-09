package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.NetworkAlbum
import com.mshdabiola.network.model.comp.NetworkTrack
import kotlinx.serialization.Serializable

@Serializable
data class UserAlbum(
	val addedAt: String?=null,
	val album: NetworkAlbum
)
