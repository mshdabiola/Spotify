package com.mshdabiola.searchscreen



import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel



@Composable
internal fun SearchScreen(searchViewModel: SearchViewModel = hiltViewModel(),onBack : ()->Unit) {
    SearchScreen(back=onBack)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun SearchScreen(
back : ()->Unit={}
) {

}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen()

}