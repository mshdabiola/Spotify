package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Category(
	val name: String,
	val href: String,
	val id: String,
	val icons: List<ImagesItem>
)
