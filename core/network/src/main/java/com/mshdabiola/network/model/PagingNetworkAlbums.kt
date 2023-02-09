package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.NetworkAlbums
import kotlinx.serialization.Serializable

@Serializable
data class PagingNetworkAlbums(
	val albums: NetworkAlbums
)
