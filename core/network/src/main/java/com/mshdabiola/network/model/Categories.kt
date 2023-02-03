package com.mshdabiola.network.model

import com.mshdabiola.network.model.component.Category

data class Categories(
	val categories: Categories? = null,
	val next: String? = null,
	val total: Int? = null,
	val offset: Int? = null,
	val previous: Any? = null,
	val limit: Int? = null,
	val href: String? = null,
	val items: List<Category?>? = null
)
