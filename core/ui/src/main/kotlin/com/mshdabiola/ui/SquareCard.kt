package com.mshdabiola.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@Composable
internal fun SquareCard(
    modifier: Modifier = Modifier,
    image: String,
    title: String? = null,
    subTitle: String,
) {

    Column(
        modifier =
        modifier
            .width(150.dp)
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))

    ) {
        AsyncImage(
            modifier = Modifier.aspectRatio(1f),
            model = image,
            contentDescription = "track",
            //  placeholder = painterResource(id = R.drawable.btn_star)
        )
        if (title != null) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleSmall,
                maxLines = 1
            )
        }
        Text(
            modifier = Modifier.alpha(0.7f),
            text = subTitle,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 2
        )


    }

}

@Preview(showBackground = true)
@Composable
internal fun SquareCardPreview() {
    SquareCard(image = "", title = "Yoga", subTitle = "Single * Asake")
}