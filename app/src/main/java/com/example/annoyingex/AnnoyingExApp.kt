package com.example.annoyingex

import android.app.Application

class AnnoyingExApp: Application() {
    lateinit var annoyingWorkManager: AnnoyingWorkManager
        private set
    lateinit var apiManager: ApiManager
        private set
    lateinit var notificationManager: NotificationManager
        private set

    override fun onCreate() {
        super.onCreate()

        annoyingWorkManager = AnnoyingWorkManager(this)
        apiManager = ApiManager(this)
        notificationManager = NotificationManager(this)
    }
}