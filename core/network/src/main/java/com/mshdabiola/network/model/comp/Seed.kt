package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Seed(
    val id: String,
    val href: String? = null,
    val type: String,
    val initialPoolSize: Int,
    val afterRelinkingSize: Int,
    val afterFilteringSize: Int
)
