package com.mshdabiola.spotify

import android.content.ComponentName
import android.content.Context
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.Player
import androidx.media3.session.MediaController
import androidx.media3.session.SessionToken
import com.google.common.util.concurrent.MoreExecutors
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MPlayer @Inject constructor(
    @ApplicationContext val context: Context,
) {
    private var mediaController: MediaController? = null
    var listener: Listener? = null

    init {
        val sessionToken =
            SessionToken(context, ComponentName(context, PlayMediaService::class.java))
        val future = MediaController.Builder(context, sessionToken)
            .buildAsync()

        future.addListener({
            mediaController = future.get()
            mediaController?.addListener(
                object : Player.Listener {
                    override fun onIsPlayingChanged(isPlaying: Boolean) {
                        super.onIsPlayingChanged(isPlaying)
                        listener?.onIsPlayingChanged(isPlaying)
                    }

                    override fun onMediaMetadataChanged(mediaMetadata: MediaMetadata) {
                        super.onMediaMetadataChanged(mediaMetadata)
                        listener?.onMetadataChanged(mediaMetadata)

                    }
                }
            )

        }, MoreExecutors.directExecutor())
    }

    fun setMediaItem(media: List<MediaItem>) {
        mediaController?.setMediaItems(media)
        mediaController?.prepare()
    }

    fun play() {
        mediaController?.seekTo(0)
        mediaController?.play()
    }


    fun getProgress() = mediaController?.getProgress()

    fun onClear() {
        mediaController?.release()
    }

    fun pause() {
        mediaController?.pause()
    }

    interface Listener {
        fun onIsPlayingChanged(isPlay: Boolean)
        fun onMetadataChanged(metadata: MediaMetadata)
    }

}

