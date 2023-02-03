package com.mshdabiola.network.model

import com.mshdabiola.network.model.component.Playlist

data class Playlists(
	val next: String? = null,
	val total: Int? = null,
	val offset: Int? = null,
	val previous: String? = null,
	val limit: Int? = null,
	val href: String? = null,
	val playlists: List<Playlist?>? = null
)
