package com.mshdabiola.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mshdabiola.ui.data.AlbumUiState

@Composable
fun AlbumCard(track: AlbumUiState) {

    SquareCard(
        image = track.imageUri,
        title = track.name,
        subTitle = "${track.type} ● ${track.artist}"
    )
}

@Preview(showBackground = true)
@Composable
fun AlbumCardPreview() {

    AlbumCard(
        track = AlbumUiState(
            id = "12",
            name = "Yoga",
            artist = "Asake",
            imageUri = "",
            type = "Single",
            releaseDate = "Jocob",
            albumType = "Nickie"
        )
    )
}