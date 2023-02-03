package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Restrictions(
	val reason: String? = null
)
