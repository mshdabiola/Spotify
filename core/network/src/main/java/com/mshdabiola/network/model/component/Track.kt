package com.mshdabiola.network.model.component

import kotlinx.serialization.Serializable

@Serializable
data class Track(
	val discNumber: Int? = null,
	val album: Album,
	val externalIds: ExternalIds? = null,
	val uri: String? = null,
	val durationMs: Int? = null,
	val explicit: Boolean? = null,
	val isPlayable: Boolean? = null,
	val linkedFrom: LinkedFrom? = null,
	val previewUrl: String? = null,
	val popularity: Int? = null,
	val trackNumber: Int? = null,
	val href: String? = null,
	val isLocal: Boolean? = null,
	val externalUrls: ExternalUrls? = null,
	val type: String,
	val artists: List<Artist>,
	val name: String,
	val id: String,
)
