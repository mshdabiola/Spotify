package com.mshdabiola.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
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
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.toImmutableList

@Composable
fun TrackList(track: TrackUiState) {

    ListItem(
        headlineText = { Text(text = track.name) },
        supportingText = { Text(text = track.artist.joinToString { it.name })},
        trailingContent = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription = "more")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun TrackListPreview() {

    TrackList(
        track = TrackUiState(
            id = "Deshon",
            name = "Irvin",
            artist = listOf(
                ArtistUiState(
                id = "Mallory",
                name = "Scot",
                image = "Edric",
                type = "Bridget")
            ).toImmutableList(),
            duration = 3772,
            image = "Joselyn",
            previewUri = "Lyndee",
            type = "Anil"

        )
    )
}