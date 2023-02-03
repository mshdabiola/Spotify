package com.mshdabiola.network.model

import com.mshdabiola.network.model.component.Albums
import kotlinx.serialization.Serializable

@Serializable
data class NewRelease(
	val albums: Albums
)
