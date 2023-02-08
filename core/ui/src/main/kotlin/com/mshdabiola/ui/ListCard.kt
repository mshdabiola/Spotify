package com.mshdabiola.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ListCard(
    image: String,
    title: String,
    subTitle: String
) {

    ListItem(
        leadingContent = {
            AsyncImage(
                modifier = Modifier.size(100.dp),
                model = image,
                contentDescription = "track",
                //  placeholder = painterResource(id = R.drawable.btn_star)
            )
        },
        headlineText = { Text(text = title) },
        supportingText = { Text(text = subTitle) }
    )
}

@Preview(showBackground = true)
@Composable
internal fun ListCardPreview() {
    ListCard(image = "", title = "Yoga", subTitle = "Single * Asake")
}