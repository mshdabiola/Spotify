package com.mshdabiola.spotify.ui

import android.net.Uri
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import com.mshdabiola.ui.data.TrackUiState

fun TrackUiState.toMediaItem() =
//    MediaItem.Builder()
//        .setMediaId("https://p.scdn.co/mp3-preview/facd9e5b75514daefb81d6492da242068873fe93?cid=774b29d4f13844c495f206cafdad9c86")
//        .setMediaMetadata(
//            MediaMetadata.Builder()
//                .setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
//                .setArtworkUri(Uri.parse("https://i.scdn.co/image/ab67616d0000b27341462de7dd99c99f01a96695"))
//                .setAlbumTitle("YBAG")
//                .setDisplayTitle("2 Thousand")
//                .setArtist("Laycon")
//
//                .build()
//        )
//        .build()
    MediaItem
        .Builder()
        .setMediaId(
            previewUri
                ?: "android.resource://com.mshdabiola.spotify.debug/${com.mshdabiola.mainscreen.R.raw.applause}"
        )
        .setMediaMetadata(
            MediaMetadata.Builder()
                .setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
                .setArtworkUri(Uri.parse(image))
                .setTitle(name)
                .setArtist(artist.joinToString { it.name })
                .build()
        )
        .build()