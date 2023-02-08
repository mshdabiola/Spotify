package com.mshdabiola.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
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