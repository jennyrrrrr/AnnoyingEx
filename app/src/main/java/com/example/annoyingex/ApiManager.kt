package com.example.annoyingex

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson

class ApiManager(context: Context) {
    private val queue: RequestQueue = Volley.newRequestQueue(context)
    private lateinit var messages: Messages
    private var result = "unable to retrieve message"

    fun fetchMessages() {
        val messageUrl = "https://raw.githubusercontent.com/echeeUW/codesnippets/master/ex_messages.json"

        val stringRequest = StringRequest ( Request.Method.GET, messageUrl, { response ->
            val gson = Gson()
            messages = gson.fromJson(response, Messages::class.java)
            result = messages.messages[0]
            Log.i("jen", result)
        },
            {error ->
                Log.e("jen", "$error")
            })

        queue.add(stringRequest)
    }

    fun getMessage(): String {
        return result;
    }
}