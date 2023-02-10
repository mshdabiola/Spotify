package com.mshdabiola.detailscreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.ShuffleOn
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.mshdabiola.designsystem.theme.SpotifyAppTheme
import com.mshdabiola.ui.PlaylistCard
import com.mshdabiola.ui.TrackList
import com.mshdabiola.ui.data.ArtistUiState
import kotlinx.collections.immutable.toImmutableList


@Composable
internal fun DetailScreen(viewModel: DetailViewModel = hiltViewModel(), onBack: () -> Unit) {
    val detailState = viewModel.detailState.collectAsStateWithLifecycle()
    DetailScreen(
        back = onBack,
        detailState = detailState.value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DetailScreen(
    back: () -> Unit = {},
    detailState: DetailState = DetailState()
) {
    Scaffold { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            item {
                Box(Modifier.fillMaxWidth()) {
                    AsyncImage(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .size(200.dp),
                        model = detailState.image,
                        contentDescription = detailState.title
                    )
                }

            }

            item {
                Text(
                    text = detailState.title,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            item {
                val artistSize = detailState.artists.size
                val size = if (artistSize > 1) "+${artistSize - 1}" else ""
                Text(
                    text = "${detailState.artists.first().name} $size",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.alpha(0.7f)
                )
            }
            item {
                Text(
                    text = detailState.subTitle,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.alpha(0.5f)
                )
            }
            item {
                Row(Modifier.fillMaxWidth()) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "favorite"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "move"
                        )
                    }
                    Spacer(modifier = Modifier.weight(1f))
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.ShuffleOn,
                            contentDescription = "shuffle"
                        )
                    }
                    FilledIconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.PlayArrow, contentDescription = "play")
                    }
                }
            }
            items(detailState.trackList, key = { it.id }) {
                TrackList(track = it)
            }
            item {
                Text(text = detailState.date)
            }
            items(detailState.artists, key = { it.id }) {
                ListItem(
                    leadingContent = {
                        AsyncImage(
                            modifier = Modifier.size(44.dp),
                            model = it.image,
                            contentDescription = it.name
                        )
                    },
                    headlineText = { Text(text = it.name) })
            }
            item {
                Text(text = "You might also like")
            }
            item {
                LazyRow(){
                    items(detailState.playList,key = {it.id}){
                        PlaylistCard(playlist = it)
                    }
                }
            }
            item { Text(text = "© ℗ ${detailState.artists.first().name}") }
            item{
                Box(modifier = Modifier.size(80.dp))
            }
        }
    }
}

@Preview
@Composable
fun DetailScreenPreview() {
   // SpotifyAppTheme {
        DetailScreen(
            detailState = DetailState(
                image = "",
                artists = listOf(
                    ArtistUiState("1", "Abiola", "", ""),
                    ArtistUiState("2", "Moshood", "", "")

                ).toImmutableList()
            )
        )
  //  }


}