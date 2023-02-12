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
import com.google.common.util.concurrent.MoreExecutors
import com.mshdabiola.common.media.PlayMediaService
import com.mshdabiola.ui.data.ArtistUiState
import com.mshdabiola.ui.data.TrackUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.delay
import timber.log.Timber

@Composable
fun PlayerBar(
    modifier: Modifier=Modifier,
    tracks: ImmutableList<TrackUiState>,

) {
    var currIndex by remember {
        mutableStateOf<Int?>(null)
    }
    var progress by remember {
        mutableStateOf(0f)
    }
    var mediaController by remember {
        mutableStateOf<MediaController?>(null)
    }
    var isPlaying by remember {
        mutableStateOf(false)
    }
    val lifecycle= LocalLifecycleOwner.current
    val context= LocalContext.current

    val observer = object : DefaultLifecycleObserver {
        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
            val sessionToken=
                SessionToken(context, ComponentName(context, PlayMediaService::class.java))
            val future=MediaController.Builder(context,sessionToken)
                .buildAsync()
            future.addListener({
                mediaController=future.get()
                Timber.e("Set Mediacontroller")

            }, MoreExecutors.directExecutor())
        }

        override fun onPause(owner: LifecycleOwner) {
            super.onPause(owner)
           mediaController?.release()
        }
    }
    DisposableEffect(key1 = lifecycle.lifecycle, effect = {
        lifecycle.lifecycle.addObserver(observer)
        onDispose { lifecycle.lifecycle.removeObserver(observer) }
    })
    LaunchedEffect(key1 =isPlaying , block ={
        if (isPlaying){
            while (true){
                delay(1000)
                mediaController?.apply {
                    if (currIndex!=currentMediaItemIndex){
                        currIndex=currentMediaItemIndex
                    }
                    progress=(currentPosition/duration.toFloat())
                    Timber.e("curren $currentPosition $duration")
                    if (!isLoading&&!isPlaying()){
                        isPlaying=false
                    }
                }
            }
        }
    } )
    LaunchedEffect(key1 = tracks, block = {
        if (tracks.isNotEmpty()) {
            Timber.e(tracks.joinToString())
            mediaController?.apply {
                setMediaItems(tracks.map { it.toMediaItem() })
                prepare()
                play()
               // currIndex=0
                isPlaying = true
            }
        }
    })

    currIndex?.let{index->
        Box(modifier) {
            ListItem(
                modifier = Modifier.clip(RoundedCornerShape(8.dp)),
                leadingContent = {
                    AsyncImage(
                        modifier = Modifier
                            .size(44.dp),
                        model = tracks[index].image,
                        contentDescription = "image"
                    )
                },
                headlineText = {
                    Text(text = tracks[index].name, maxLines = 1)
                },
                supportingText = { Text(text =tracks[index].artist.joinToString { it.name }, maxLines = 1) },
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
                        IconButton(onClick = {
                            mediaController?.apply {
                                this.seekTo(0)
                                play()
                                isPlaying=true
                            }
                        }) {
                            Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
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
                progress = progress
            )
        }
    }

}

@Preview
@Composable
fun PlayerBarPreview() {
    PlayerBar(tracks = listOf( TrackUiState(
        id = "Kalina",
        name = "Doron",
        artist = emptyList<ArtistUiState>().toImmutableList(),
        duration = 3180,
        image = "Delvin",
        previewUri = "Kalah",
        type = "Lakeysha"
    )).toImmutableList())
}