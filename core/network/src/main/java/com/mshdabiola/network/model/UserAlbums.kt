package com.mshdabiola.network.model

import kotlinx.serialization.Serializable

@Serializable
data class UserAlbums(
	val next: String?=null,
	val total: Int?=null,
	val offset: Int?=null,
	val previous: String?=null,
	val limit: Int?=null,
	val items: List<UserAlbum>
)
