package com.timothypaetz.android.fetchrewards

import android.app.Application
import timber.log.Timber

class FetchApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}