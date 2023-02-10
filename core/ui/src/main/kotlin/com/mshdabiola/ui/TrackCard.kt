package com.mshdabiola.ui

import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mshdabiola.ui.data.TrackUiState

@Composable
fun TrackCard(
    track: TrackUiState,
    onClick : (String,String)->Unit={_,_->}
) {

    SquareCard(
        Modifier.clickable {
                           onClick(track.id,"track")
        },
        image = track.image,
        title = track.name,
        subTitle = "${track.type} ● ${track.artist}",

    )
}

@Preview(showBackground = true)
@Composable
fun TrackCardPreview() {

    TrackCard(
        track = TrackUiState(
            id = "Deshon",
            name = "Irvin",
            artist = "Esther",
            duration = 3772,
            image = "Joselyn",
            previewUri = "Lyndee",
            type = "Anil"

        )
    )
}