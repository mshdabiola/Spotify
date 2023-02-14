package com.mshdabiola.network.model

import com.mshdabiola.network.model.comp.ImagesItem
import com.mshdabiola.network.model.comp.NetworkTrack
import kotlinx.serialization.Serializable

@Serializable
data class OnePlaylist(
    val owner: Owner,
    val images: List<ImagesItem>,
    val description: String,
    val type: String,
    val tracks: PTracks,
    val name: String,
    val id: String,
)

@Serializable
data class Owner(
    val id: String,
    val displayName: String? = null,
    val type: String,
)

@Serializable
data class ItemsItem(
    val track: NetworkTrack
)

@Serializable
data class PTracks(
    val next: String? = null,
    val total: Int,
    val offset: Int,
    val previous: String? = null,
    val limit: Int,
    val href: String,
    val items: List<ItemsItem>
)

