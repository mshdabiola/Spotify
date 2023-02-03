package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Image(
	val width: Int,
	val url: String,
	val height: Int
)
