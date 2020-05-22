package com.example.annoyingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var annoyingExApp: AnnoyingExApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        annoyingExApp = application as AnnoyingExApp
        annoyingExApp.apiManager.fetchMessages()

        val dataFromNotification = intent.getStringExtra("text")
        tvText.text = dataFromNotification
        btnStart.setOnClickListener {
            annoyingExApp.annoyingWorkManager.startTask()
//            annoyingExApp.buttonManager.postNote(message)
        }
        btnStop.setOnClickListener{
            annoyingExApp.annoyingWorkManager.stopWork()
        }
    }
}
