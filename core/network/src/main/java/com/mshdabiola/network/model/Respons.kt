package com.mshdabiola.network.model

data class Respons(
	val images: List<ImagesItem>,
	val copyrights: List<CopyrightsItem>,
	val availableMarkets: List<String>,
	val releaseDatePrecision: String,
	val label: String,
	val type: String,
	val externalIds: ExternalIds,
	val uri: String,
	val tracks: Tracks,
	val totalTracks: Int,
	val artists: List<ArtistsItem>,
	val releaseDate: String,
	val genres: List<Any>,
	val popularity: Int,
	val name: String,
	val albumType: String,
	val href: String,
	val id: String,
	val externalUrls: ExternalUrls
)

data class ExternalUrls(
	val spotify: String
)

data class ItemsItem(
	val discNumber: Int,
	val availableMarkets: List<String>,
	val type: String,
	val uri: String,
	val durationMs: Int,
	val explicit: Boolean,
	val artists: List<ArtistsItem>,
	val previewUrl: String,
	val name: String,
	val trackNumber: Int,
	val href: String,
	val id: String,
	val isLocal: Boolean,
	val externalUrls: ExternalUrls
)

data class CopyrightsItem(
	val text: String,
	val type: String
)

data class ExternalIds(
	val upc: String
)

data class ImagesItem(
	val width: Int,
	val url: String,
	val height: Int
)

data class ArtistsItem(
	val name: String,
	val href: String,
	val id: String,
	val type: String,
	val externalUrls: ExternalUrls,
	val uri: String
)

data class Tracks(
	val next: Any,
	val total: Int,
	val offset: Int,
	val previous: Any,
	val limit: Int,
	val href: String,
	val items: List<ItemsItem>
)

