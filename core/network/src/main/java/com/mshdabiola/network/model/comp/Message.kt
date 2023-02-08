package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Message(
	val error: Error
)
