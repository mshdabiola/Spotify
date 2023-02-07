package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.Categories
import kotlinx.serialization.Serializable

@Serializable
data class CategoryItem(
	val categories: Categories
)
