package com.mshdabiola.libraryscreen


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mshdabiola.ui.AlbumCard
import com.mshdabiola.ui.TrackCard


@Composable
internal fun LibraryScreen(
    libraryViewModel: LibraryViewModel = hiltViewModel(),
    onNavigateToDetail : (String,String)->Unit={_,_->}
) {
    val libraryUiState=libraryViewModel.libraryUiState.collectAsStateWithLifecycle()
    LibraryScreen(
        libraryUiState = libraryUiState.value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun LibraryScreen(
    libraryUiState: LibraryUiState= LibraryUiState()
) {
    Column {
        TopAppBar(
            title = { Text(text = "Your Library") },
            navigationIcon = {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Color.Green)
                        .size(36.dp)

                ){
                    Text(
                    modifier = Modifier.align(Alignment.Center),
                        text = "M",
                        color = Color.White,
                        style = MaterialTheme.typography.titleLarge
                    )
                }

            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
                }
            }
        )
        Row (horizontalArrangement = Arrangement.spacedBy(8.dp)){
            AssistChip(onClick = { /*TODO*/ }, label = {
                Text(text = "Playlists")
            })
            AssistChip(onClick = { /*TODO*/ }, label = {
                Text(text = "Albums")
            })
            AssistChip(onClick = { /*TODO*/ }, label = {
                Text(text = "Artists")
            })
        }
        LazyVerticalGrid(

            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)

        ){
            items(libraryUiState.userAlbums, key = {it.id}){
                AlbumCard(track = it)
            }
            items(libraryUiState.userTracks, key = {it.id}){
                TrackCard(track = it)
            }
        }
    }

}

@Preview
@Composable
internal fun LibraryScreenPreview() {
    LibraryScreen()

}