package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Copyright(
	val text: String? = null,
	val type: String? = null
)
