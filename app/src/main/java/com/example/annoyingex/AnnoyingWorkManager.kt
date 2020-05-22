package com.example.annoyingex

import android.content.Context
import android.util.Log
import androidx.work.*
import java.util.concurrent.TimeUnit

class AnnoyingWorkManager(context: Context) {
    private var workManager = WorkManager.getInstance(context)

    fun startTask() {
        if (!isRunning()) {
            stopWork()
        }
        val constraints = Constraints.Builder()
            .setRequiresCharging(true)
            .build()

        val workRequest = OneTimeWorkRequestBuilder<RepetitiveWorker>()
            .setInitialDelay(5000, TimeUnit.MILLISECONDS)
            .setConstraints(constraints)
            .addTag(WORK_REQUEST_TAG)
            .build()

        workManager.enqueue(workRequest)
    }

    private fun isRunning(): Boolean {
        return when(workManager.getWorkInfosByTag(WORK_REQUEST_TAG).get().firstOrNull()?.state) {
            WorkInfo.State.RUNNING,
            WorkInfo.State.ENQUEUED -> true
            else -> false
        }
    }

    fun stopWork() {
        workManager.cancelAllWorkByTag(WORK_REQUEST_TAG)
    }

    companion object {
        const val WORK_REQUEST_TAG = "WORK_REQUEST_TAG"
    }
}