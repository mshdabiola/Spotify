package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Artist(
	val name: String ,
//	val href: String? = null,
	val id: String? = null,
//	val type: String? = null,
//	val externalUrls: ExternalUrls? = null,
//	val uri: String? = null,
	val images: List<Image?>? = null,
//	val followers: Followers? = null,
//	val genres: List<String?>? = null,
//	val popularity: Int? = null
)
