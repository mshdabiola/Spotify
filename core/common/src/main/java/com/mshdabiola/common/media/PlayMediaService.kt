package com.mshdabiola.common.media

import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.session.MediaSession
import androidx.media3.session.MediaSessionService
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import timber.log.Timber

class PlayMediaService :MediaSessionService() ,MediaSession.Callback {

    private lateinit var session : MediaSession
    private lateinit var player: ExoPlayer
    override fun onCreate() {
        super.onCreate()
        player = ExoPlayer.Builder(this)
            .build()
        session=MediaSession.Builder(this,player)
            .setCallback(this)
            .build()

        Timber.e("on create service")
    }
    override fun onGetSession(controllerInfo: MediaSession.ControllerInfo): MediaSession {

        Timber.e("package ${controllerInfo.packageName} ${controllerInfo.controllerVersion}")
        return session
    }

    override fun onDestroy() {
        super.onDestroy()
        player.release()
        session.release()
    }

    override fun onAddMediaItems(
        mediaSession: MediaSession,
        controller: MediaSession.ControllerInfo,
        mediaItems: MutableList<MediaItem>
    ): ListenableFuture<MutableList<MediaItem>> {
        val updatedMediaitems=mediaItems
            .map { it.buildUpon()
                .setUri(it.mediaId).build() }
//            .map { it.buildUpon().build() }
            .toMutableList()
        return Futures.immediateFuture(updatedMediaitems)
    }


}