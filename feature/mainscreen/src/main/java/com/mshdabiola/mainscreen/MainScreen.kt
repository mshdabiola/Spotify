package com.mshdabiola.mainscreen

import android.app.Activity
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mshdabiola.designsystem.theme.SpotifyAppTheme
import com.mshdabiola.ui.AlbumCard
import com.mshdabiola.ui.ArtistCard
import com.mshdabiola.ui.PlaylistCard
import com.mshdabiola.ui.TrackCard
import com.mshdabiola.ui.data.AlbumUiState
import com.mshdabiola.ui.data.ArtistUiState
import com.spotify.sdk.android.auth.AuthorizationClient
import com.spotify.sdk.android.auth.AuthorizationRequest
import com.spotify.sdk.android.auth.AuthorizationResponse
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import timber.log.Timber

@Composable
internal fun MainScreen(
    viewModel: MainViewModel = hiltViewModel(),
    onNavigateToDetail: (String, String) -> Unit = { _, _ -> },
    showNavBar: (Boolean) -> Unit = {}
) {
    val mainState = viewModel.mainState.collectAsState()
    val context = LocalContext.current
    LaunchedEffect(key1 = Unit, block = {
        val activity = context as Activity
        val uri = activity.intent?.data
        if (uri != null) {
            val response = AuthorizationResponse.fromUri(uri)
            when (response.type) {
                AuthorizationResponse.Type.TOKEN -> {
                    Timber.e("access ${response.accessToken}")
                    Timber.e("expire ${response.expiresIn}")
                    viewModel.setToken(response.accessToken)
                }

                AuthorizationResponse.Type.ERROR -> {}
                else -> {}
            }
        }
    })
    LaunchedEffect(key1 = mainState.value.showLogin, block = {
        showNavBar(!mainState.value.showLogin)
//        showNavBar(false)
    })
    MainScreen(
        mainState = mainState.value,
        onNavigateToDetail = onNavigateToDetail

    )
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun MainScreen(
    mainState: MainState,
    onNavigateToDetail: (String, String) -> Unit = { _, _ -> }
) {
    val scrollState = rememberScrollState()
    val context = LocalContext.current

    Crossfade(targetState = mainState.showLogin) {
        if (it) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(
                    modifier = Modifier,
                    onClick = {
                        val buider = AuthorizationRequest.Builder(
                            "84dfa73aba8e432eb321426804a69fb1",
                            AuthorizationResponse.Type.TOKEN,
                            "http://callback.com"
                        )
                            .setScopes(arrayOf("user-library-read"))
                            .build()
                        val intent = AuthorizationClient.createLoginActivityIntent(
                            context as Activity,
                            buider
                        )
                        //context.startActivityForResult(intent,100)
                        AuthorizationClient.openLoginInBrowser(context, buider)
                    },
                    enabled = mainState.isConnected
                ) {
                    Text(text = "Get token")
                }
                Text(
                    text = if (mainState.isConnected)
                        "Network is available"
                    else
                        "Network is not available",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        } else {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp)
                    .verticalScroll(scrollState)
            ) {


                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier.weight(1f),
                        text = "Good Morning",
                        style = MaterialTheme.typography.titleLarge
                    )
                    IconButton(onClick = { onNavigateToDetail("383838", "track") }) {
                        Icon(
                            imageVector = Icons.Outlined.Notifications,
                            contentDescription = "notification"
                        )
                    }
                    IconButton(onClick = {


                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Alarm,
                            contentDescription = "notification"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "notification"
                        )
                    }
                }
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    AssistChip(onClick = {

                    }, label = { Text(text = "Music") })
                    AssistChip(onClick = { /*TODO*/ }, label = { Text(text = "Podcasts & Shows") })
                }

                Text(
                    text = "New Release",
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(items = mainState.newRelease, key = { it.id }) {
                        AlbumCard(
                            albumUiState = it,
                            onClick = onNavigateToDetail
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Recommendations",
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(items = mainState.recommendations, key = { it.id }) {
                        TrackCard(
                            track = it,
                            onClick = onNavigateToDetail
                        )
                    }
                }
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Editor's Pick",
                    style = MaterialTheme.typography.titleLarge,
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(items = mainState.featurePlaylist, key = { it.id }) {
                        PlaylistCard(
                            playlist = it,
                            onClick = onNavigateToDetail
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Artists",
                    style = MaterialTheme.typography.titleLarge
                )
                Spacer(modifier = Modifier.height(8.dp))
                LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(items = mainState.relatedArtiste, key = { it.id }) {
                        ArtistCard(artist = it)
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(176.dp)
                )


            }
        }
    }


}


@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    val release = (1..5)
        .map {
            AlbumUiState(
                id = "Arya$it",
                name = "Nada",
                releaseDate = 87,
                albumType = "Deanthony",
                type = "Maribel",
                artist = listOf(
                    ArtistUiState(
                        id = "Mallory",
                        name = "Scot",
                        image = "Edric",
                        type = "Bridget"
                    )
                ).toImmutableList(),
                imageUri = "Dru"

            )
        }
        .toImmutableList()
    SpotifyAppTheme {
        MainScreen(mainState = MainState(newRelease = release))
    }

}

@Composable
fun MainRow(
    title: String,
    tracks: ImmutableList<AlbumUiState>
) {


    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary
    )
    Spacer(modifier = Modifier.height(8.dp))
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(items = tracks) {
            AlbumCard(albumUiState = it)
        }
    }
}
