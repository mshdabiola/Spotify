package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class LinkedFrom(
	val href: String? = null,
	val id: String? = null,
	val type: String? = null,
	val externalUrls: ExternalUrls? = null,
	val uri: String? = null
)
