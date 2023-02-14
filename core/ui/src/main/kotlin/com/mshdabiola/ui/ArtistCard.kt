package com.mshdabiola.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mshdabiola.ui.data.ArtistUiState

@Composable
fun ArtistCard(artist: ArtistUiState) {

    CircleCard(
        image = artist.image,
        title = artist.name,
    )
}

@Preview(showBackground = true)
@Composable
fun ArtistCardPreview() {

    ArtistCard(
        artist = ArtistUiState(id = "Kacey", name = "Kadi", image = "Robert", type = "Valentino")
    )
}