package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.NetworkTrack
import kotlinx.serialization.Serializable

@Serializable
data class UserTrack(
	val addedAt: String?=null,
	val track: NetworkTrack
)
