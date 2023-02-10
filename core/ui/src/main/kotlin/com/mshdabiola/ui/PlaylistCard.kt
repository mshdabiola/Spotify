package com.mshdabiola.ui

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mshdabiola.ui.data.PlaylistUiState

@Composable
fun PlaylistCard(
    playlist: PlaylistUiState,
    onClick : (String,String)->Unit={_,_->}
) {

    SquareCard(
        modifier = Modifier.clickable {
            onClick(playlist.id,"playlist")
        },
        image = playlist.image,
        //title = playlist.name,
        subTitle = playlist.description,
    )
}

@Preview(showBackground = true)
@Composable
fun PlaylistCardPreview() {

    PlaylistCard(
       playlist = PlaylistUiState(
           id = "Marshal", name = "Kellie", description = "Steffany", image = "Iliana"

       )
    )
}