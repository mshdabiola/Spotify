package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class ImagesItem(
	val width: Int,
	val url: String,
	val height: Int
)
