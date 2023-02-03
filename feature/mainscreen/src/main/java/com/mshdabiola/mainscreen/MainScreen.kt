package com.mshdabiola.mainscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mshdabiola.designsystem.theme.SpotifyAppTheme
import com.mshdabiola.ui.AlbumCard
import com.mshdabiola.ui.data.AlbumUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Composable
internal fun MainScreen(viewModel: MainViewModel = hiltViewModel(), onBack: () -> Unit) {
    val mainState = viewModel.mainState.collectAsState()
    MainScreen(
        back = onBack,
        mainState = mainState.value

    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MainScreen(
    mainState: MainState = MainState(),
    back: () -> Unit = {},
) {
    Column(Modifier.fillMaxSize()) {
        MainRow(title = "New Release", tracks = mainState.newRelease)
        Spacer(modifier = Modifier.height(16.dp))
        MainRow(title = "Recommendations", tracks = mainState.recommendations)


    }
}


@Preview
@Composable
fun MainScreenPreview() {
    val release = (1..5)
        .map { AlbumUiState(id = "$it", "Yoga", "Spiritual", "Asake", "") }
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
            AlbumCard(track = it)
        }
    }
}
