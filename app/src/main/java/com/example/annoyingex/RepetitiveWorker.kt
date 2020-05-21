package com.example.annoyingex

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RepetitiveWorker(context: Context, workParams: WorkerParameters): Worker(context , workParams) {
    private val annoyingExApp = (applicationContext as AnnoyingExApp)
    private val apiManager = annoyingExApp.apiManager
    private val notificationManager = annoyingExApp.notificationManager

    override fun doWork(): Result {
        notificationManager.postNote(apiManager.getMessage())

        return Result.success()
    }
}