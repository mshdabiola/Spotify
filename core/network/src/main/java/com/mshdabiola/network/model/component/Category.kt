package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Category(
	val name: String? = null,
	val href: String? = null,
	val id: String? = null,
	val icons: List<Image?>? = null
)
