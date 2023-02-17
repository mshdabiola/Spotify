package com.mshdabiola.spotify.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Speaker
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mshdabiola.spotify.MediaData

@Composable
fun PlayerBar(
    modifier: Modifier = Modifier,
    mediaData: MediaData,
    onPlay: () -> Unit = {}
) {

    if (mediaData.showPlayer) {

        Box(modifier) {
            ListItem(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                leadingContent = {
                    AsyncImage(
                        modifier = Modifier
                            .size(44.dp),
                        model = mediaData.image,
                        contentDescription = "image"
                    )
                },
                headlineText = {
                    Text(text = mediaData.title ?: "", maxLines = 1)
                },
                supportingText = {
                    Text(
                        text = mediaData.artists ?: "",
                        maxLines = 1
                    )
                },
                trailingContent = {
                    Row {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Speaker,
                                contentDescription = "speaker"
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.FavoriteBorder,
                                contentDescription = "favorite"
                            )
                        }
                        IconButton(onClick = onPlay) {
                            Icon(
                                imageVector = if (mediaData.isPlaying) Icons.Default.Pause else Icons.Default.PlayArrow,
                                contentDescription = "play"
                            )
                        }
                    }
                },
                colors = ListItemDefaults.colors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            )
            LinearProgressIndicator(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                progress = mediaData.progress
            )
        }

    }
    // }
}

@Preview
@Composable
fun PlayerBarPreview() {
    PlayerBar(
        mediaData = MediaData()
    )
}