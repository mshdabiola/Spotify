package com.mshdabiola.ui

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.ArtistUiState
import kotlinx.collections.immutable.toImmutableList
import kotlinx.collections.immutable.toImmutableSet

@Composable
fun AlbumCard(
    albumUiState: AlbumUiState,
    onClick: (String, String) -> Unit = { _, _ -> }
) {

    SquareCard(
        modifier = Modifier.clickable {
            onClick(albumUiState.id, "album")
        },
        image = albumUiState.imageUri,
        title = albumUiState.name,
        subTitle = "${albumUiState.type} ● ${albumUiState.artist.joinToString { it.name }}",
    )
}

@Preview(showBackground = true)
@Composable
fun AlbumCardPreview() {

    AlbumCard(
        albumUiState = AlbumUiState(
            id = "12",
            name = "Yoga",
            artist = listOf(ArtistUiState(
                id = "Mallory",
                name = "Scot",
                image = "Edric",
                type = "Bridget")
            ).toImmutableList(),
            imageUri = "",
            type = "Single",
            releaseDate = 636,
            albumType = "Nickie"
        )
    )
}