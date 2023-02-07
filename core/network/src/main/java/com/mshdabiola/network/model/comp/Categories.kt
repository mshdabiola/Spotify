package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Categories(
	val next: String,
	val total: Int,
	val offset: Int,
	val previous: String,
	val limit: Int,
	val href: String,
	val items: List<Category>
)
