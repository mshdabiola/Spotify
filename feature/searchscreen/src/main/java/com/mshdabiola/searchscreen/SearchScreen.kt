package com.mshdabiola.searchscreen


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mshdabiola.ui.GenreCard
import com.mshdabiola.ui.data.GenreUiState
import kotlinx.collections.immutable.toImmutableList
import timber.log.Timber


@Composable
internal fun SearchScreen(searchViewModel: SearchViewModel = hiltViewModel(), onBack: () -> Unit) {
    val searchUiState = searchViewModel.searchUiState.collectAsState()
    SearchScreen(
        back = onBack,
        searchUiState.value
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchScreen(
    back: () -> Unit = {},
    searchUiState: SearchUiState
) {

        LazyVerticalGrid(
            modifier = Modifier
                .padding(horizontal = 16.dp)
            ,

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
            item(span = {GridItemSpan(2)}) {

                    SearchBar(
                        modifier = Modifier,
                        query = "",
                        onQueryChange = {},
                        onSearch = {},
                        active = true,
                        placeholder = { Text(text = "What do you want to listen to?")},
                        onActiveChange = {},
                        leadingIcon = { Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "search"
                        )}
                    ) {
                    }


            }
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

