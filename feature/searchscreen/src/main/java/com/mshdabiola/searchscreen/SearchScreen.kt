package com.mshdabiola.searchscreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mshdabiola.ui.GenreCard
import com.mshdabiola.ui.TrackCard
import com.mshdabiola.ui.data.GenreUiState
import kotlinx.collections.immutable.toImmutableList


@Composable
internal fun SearchScreen(
    searchViewModel: SearchViewModel = hiltViewModel(),
    onNavigateToDetail: (String, String) -> Unit = { _, _ -> }
) {
    val searchUiState = searchViewModel.searchUiState.collectAsState()
    SearchScreen(
        searchUiState.value,
        onSearch = searchViewModel::search,
        onNavigateToDetail = onNavigateToDetail
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchScreen(
    searchUiState: SearchUiState,
    onSearch: (String) -> Unit = {},
    onNavigateToDetail: (String, String) -> Unit = { _, _ -> }
) {

    var search by remember {
        mutableStateOf("")
    }
    LazyVerticalGrid(
        modifier = Modifier
            .padding(horizontal = 16.dp),

        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item {
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = "Search",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
        }
        item(span = { GridItemSpan(2) }) {

            SearchBar(
                modifier = Modifier,
                query = search,
                onQueryChange = {
                    search = it
                    onSearch(it)
                },
                onSearch = {
                    onSearch(it)
                },
                active = false,
                placeholder = { Text(text = "What do you want to listen to?") },
                onActiveChange = {},
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "search"
                    )
                },
                //colors = SearchBarDefaults.colors(containerColor = Color.White, inputFieldColors = TextFieldDefaults.textFieldColors())
            ) {
            }


        }

        if (searchUiState.tracks.isEmpty()) {
            item(span = { GridItemSpan(2) }) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Browse All",
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            }
            items(searchUiState.genres, key = { it.id }) {
                GenreCard(genreUiState = it)

            }
        } else {
            items(searchUiState.tracks, key = { it.id }) {
                TrackCard(
                    track = it,
                    onClick = onNavigateToDetail
                )
            }
        }
        item(span = { GridItemSpan(2) }) {
            Box(
                modifier = Modifier
                    //.background(Color.Blue)
                    .size(192.dp)
            )
        }

    }


}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(
        searchUiState = SearchUiState(
            genres = listOf(
                GenreUiState(0, 2, "Afro"),
                GenreUiState(1, 3, "Electric"),
                GenreUiState(2, 1, "Juju")
            ).toImmutableList()
        )
    )

}

