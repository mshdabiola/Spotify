package com.mshdabiola.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
internal fun CircleCard(
     image:String,
     title: String
) {

    Column(
        modifier =
        Modifier
            .width(150.dp),
        horizontalAlignment = Alignment.CenterHorizontally


    ) {
        AsyncImage(
            modifier = Modifier
                .aspectRatio(1f)
                .clip(CircleShape),
            model = image,
            contentDescription = "track",
            //  placeholder = painterResource(id = R.drawable.btn_star)
        )

            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1
            )
    }

}

@Preview(showBackground = true)
@Composable
internal fun CircleCardPreview() {
    CircleCard(image = "", title = "Asake")
}