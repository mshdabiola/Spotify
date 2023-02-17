package com.mshdabiola.spotify

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import com.mshdabiola.designsystem.theme.SpotifyAppTheme
import com.mshdabiola.spotify.ui.SpotifyApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    val mainViewModel by viewModels<MainViewModel>()

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            WindowCompat.setDecorFitsSystemWindows(window, false)
            SpotifyAppTheme {
                // A surface container using the 'background' color from the theme
                SpotifyApp(
                    windowSizeClass = calculateWindowSizeClass(activity = this),
                    mainViewModel = mainViewModel
                )
            }
        }

    }

    override fun onStart() {
        super.onStart()


        val mediaItem2 = MediaItem.Builder()
            .setMediaId("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
            .setMediaMetadata(
                MediaMetadata.Builder()
                    .setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
                    .setArtworkUri(Uri.parse("https://i.pinimg.com/736x/4b/02/1f/4b021f002b90ab163ef41aaaaa17c7a4.jpg"))
                    .setAlbumTitle("SoundHelix")
                    .setDisplayTitle("Song 1")
                    .build()
            ).build()
        val mediaItem3 = MediaItem.Builder()
            .setMediaId("https://p.scdn.co/mp3-preview/facd9e5b75514daefb81d6492da242068873fe93?cid=774b29d4f13844c495f206cafdad9c86")
            .setMediaMetadata(
                MediaMetadata.Builder()
                    .setFolderType(MediaMetadata.FOLDER_TYPE_ALBUMS)
                    .setArtworkUri(Uri.parse("https://i.scdn.co/image/ab67616d0000b27341462de7dd99c99f01a96695"))
                    .setAlbumTitle("YBAG")
                    .setDisplayTitle("2 Thousand")
                    .setArtist("Laycon")

                    .build()
            )
            .build()

        val mediaItem = MediaItem
            .Builder()
            .setMediaId("android.resource://$packageName/${com.mshdabiola.mainscreen.R.raw.applause}")
            .build()


//           listener?.addListener(
//               {
//               mediaController=listener?.get()
//                   mediaController!!.addMediaItem(mediaItem)
//                   mediaController!!.addMediaItem(mediaItem3)
//                   mediaController!!.addMediaItem(mediaItem2)
////                   mediaController!!.prepare()
////                   mediaController!!.play()
//                   Timber.e("isconnected ${mediaController!!.isConnected}")
//               },
//               MoreExecutors.directExecutor()
//           )
//        mediaController?.currentMediaItemIndex

    }


}
