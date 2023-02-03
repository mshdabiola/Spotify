package com.mshdabiola.network.model.component

import com.mshdabiola.network.model.component.Album
import kotlinx.serialization.Serializable

@Serializable
data class Albums(
	val next: String? = null,
	val total: Int? = null,
	val offset: Int? = null,
	val previous: String? = null,
	val limit: Int? = null,
	val items: List<Album>
)
