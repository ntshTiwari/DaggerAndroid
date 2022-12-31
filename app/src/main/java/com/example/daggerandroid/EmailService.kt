package com.example.daggerandroid

import android.content.ContentValues.TAG
import android.util.Log

class EmailService {
    fun send(to: String, from: String, body: String?){
        Log.e(TAG, "Email sent from: $from to: $to");
    }
}