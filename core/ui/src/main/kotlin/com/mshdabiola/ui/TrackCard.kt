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
import com.mshdabiola.ui.data.TrackUiState

@Composable
fun TrackCard(track: TrackUiState) {

    SquareCard(
        image = track.image,
        title = track.name,
        subTitle = "${track.type} ● ${track.artist}"
    )
}

@Preview(showBackground = true)
@Composable
fun TrackCardPreview() {

    TrackCard(
        track = TrackUiState(
            id = "Deshon",
            name = "Irvin",
            artist = "Esther",
            duration = 3772,
            image = "Joselyn",
            previewUri = "Lyndee",
            type = "Anil"

        )
    )
}