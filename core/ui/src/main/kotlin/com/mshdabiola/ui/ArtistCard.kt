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
import com.mshdabiola.model.Playlist
import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.PlaylistUiState
import com.mshdabiola.ui.data.TrackUiState

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