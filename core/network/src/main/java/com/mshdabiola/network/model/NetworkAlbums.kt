package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.Albums
import kotlinx.serialization.Serializable

@Serializable
data class NetworkAlbums(
	val albums: Albums
)
