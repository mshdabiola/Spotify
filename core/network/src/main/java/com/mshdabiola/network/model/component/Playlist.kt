package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
//	val owner: Owner? = null,
	val images: List<Image?>? = null,
//	val snapshotId: String? = null,
//	val collaborative: Boolean? = null,
	val description: String? = null,
//	val type: String? = null,
//	val uri: String? = null,
//	val tracks: Tracks? = null,
//	val followers: Followers? = null,
//	val jsonMemberPublic: Boolean? = null,
	val name: String? = null,
//	val href: String? = null,
	val id: String? = null,
//	val externalUrls: ExternalUrls? = null
)
