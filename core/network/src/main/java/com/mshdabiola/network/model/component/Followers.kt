package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Followers(
	val total: Int? = null,
	val href: String? = null
)
