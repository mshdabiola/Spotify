package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class ExternalIds(
	val ean: String? = null,
	val upc: String? = null,
	val isrc: String? = null
)
