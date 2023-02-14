package com.mshdabiola.spotify

import androidx.media3.session.MediaController
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import timber.log.Timber

fun MediaController.getProgress()= flow {
    while (true){
        delay(1000)
        val progressT=currentPosition/duration.toFloat()
        emit(progressT)
        Timber.e("Progress $progressT")


    }
}