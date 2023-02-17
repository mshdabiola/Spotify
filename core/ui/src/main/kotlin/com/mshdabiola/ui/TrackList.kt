package com.mshdabiola.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.toImmutableList

@Composable
fun TrackList(track: TrackUiState) {

    ListItem(
        headlineText = { Text(text = track.name) },
        supportingText = { Text(text = track.artist.joinToString { it.name }) },
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
                    type = "Bridget"
                )
            ).toImmutableList(),
            duration = 3772,
            image = "Joselyn",
            previewUri = "Lyndee",
            type = "Anil"

        )
    )
}