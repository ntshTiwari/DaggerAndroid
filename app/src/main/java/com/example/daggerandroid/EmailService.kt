package com.example.daggerandroid

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

/// here we use the [@Inject] annotation, which mean when dagger has to inject this object it can
/// create it using the constructor of the EmailService class
class EmailService @Inject constructor() {
    fun send(to: String, from: String, body: String?){
        Log.e(TAG, "Email sent from: $from to: $to");
    }
}