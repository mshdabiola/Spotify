package com.mshdabiola.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mshdabiola.ui.data.GenreUiState

@Composable
fun GenreCard(genreUiState: GenreUiState) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp),
        colors = CardDefaults.cardColors(
            contentColor = Color.White,
            containerColor = colors[genreUiState.color].copy(alpha = 0.6f)
        )
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = genreUiState.name,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )

    }
}

@Preview
@Composable
fun GenreCardPreview() {
    GenreCard(GenreUiState(8, 0, "Afro"))
}

val colors = arrayOf(
    Color.Yellow,
    Color.Green,
    Color.Red,
    Color.Magenta,
    Color(0xFFFF1744),
    Color(0xFFD500F9),
    Color(0xFF651FFF),
    Color(0xFF3D5AFE),
    Color(0xFF2979FF),
    Color(0xFF00B0FF),
    Color(0xFF00E5FF),
    Color(0xFFC6FF00),
    Color(0xFFFF9100),
)