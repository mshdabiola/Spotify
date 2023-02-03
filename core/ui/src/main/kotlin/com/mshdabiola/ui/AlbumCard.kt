package com.mshdabiola.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mshdabiola.ui.data.AlbumUiState

@Composable
fun AlbumCard(track: AlbumUiState) {

        Column(
            modifier =
            Modifier.width(150.dp)
                .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))

        ) {
            AsyncImage(
                modifier = Modifier.aspectRatio(1f),
                model = track.imageUri,
                contentDescription = "track",
                //  placeholder = painterResource(id = R.drawable.btn_star)
            )

            Text(
                text = track.title,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1
            )
            Text(
                modifier = Modifier.alpha(0.7f),
                text = "${track.type} ● ${track.artist}",
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2
            )


        }

}

@Preview
@Composable
fun AlbumCardPreview() {

    AlbumCard(
        track = AlbumUiState(
            id = "12",
            title = "Yoga",
            artist = "Asake",
            imageUri = "",
            type = "Single"
        )
    )
}