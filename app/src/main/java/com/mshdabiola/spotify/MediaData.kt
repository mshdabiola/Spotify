package com.mshdabiola.spotify

import android.net.Uri

data class MediaData(
    val image: Uri? = null,
    val title: String? = null,
    val artists: String? = null,
    val progress: Float = 0f,
    val isPlaying: Boolean = false,
    val showPlayer: Boolean = false
)
