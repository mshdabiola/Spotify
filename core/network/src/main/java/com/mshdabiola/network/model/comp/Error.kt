package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Error(
	val message: String,
	val status: Int
)
