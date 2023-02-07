package com.mshdabiola.network.model.comp

import kotlinx.serialization.Serializable

@Serializable
data class Track(
	val album: Album,
	val type: String,
	val durationMs: Int,
	val isPlayable: Boolean,
	val artists: List<ArtistsItem>,
	val previewUrl: String,
	val name: String,
	val href: String,
	val id: String,
)
