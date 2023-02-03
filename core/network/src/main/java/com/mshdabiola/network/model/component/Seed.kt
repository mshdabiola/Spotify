package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Seed(
	val id: String? = null,
	val href: String? = null,
	val type: String? = null,
	val initialPoolSize: Int? = null,
	val afterRelinkingSize: Int? = null,
	val afterFilteringSize: Int? = null
)
