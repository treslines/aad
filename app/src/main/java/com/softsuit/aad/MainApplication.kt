package com.softsuit.aad

import android.app.Application
import timber.log.Timber

class MainApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}