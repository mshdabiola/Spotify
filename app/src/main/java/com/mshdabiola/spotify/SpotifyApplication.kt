package com.mshdabiola.spotify

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class SpotifyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        //if(packageName.contains("debug")) {
            Timber.plant(Timber.DebugTree())
        //}
            Timber.e("log on app create")

    }
}
