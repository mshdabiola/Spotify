package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Tracks(
	val next: String? = null,
	val total: Int? = null,
	val offset: Int? = null,
	val previous: String? = null,
	val limit: Int? = null,
	val href: String? = null,
	val items: List<Track?>? = null
)
