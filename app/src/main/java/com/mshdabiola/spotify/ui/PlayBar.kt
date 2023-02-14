package com.mshdabiola.spotify.ui

import android.content.ComponentName
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import coil.compose.AsyncImage
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.MoreExecutors
import com.mshdabiola.spotify.MediaData
import com.mshdabiola.spotify.PlayMediaService
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import timber.log.Timber

@Composable
fun PlayerBar(
    modifier: Modifier = Modifier,
    mediaData: MediaData,
    onPlay : ()->Unit={}
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
                    Text(text = mediaData.title?:"", maxLines = 1)
                },
                supportingText = {
                    Text(
                        text = mediaData.artists ?:"",
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
                                imageVector = if (mediaData.isPlaying)Icons.Default.Pause else Icons.Default.PlayArrow,
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