package com.example.daggerandroid

import android.content.ContentValues.TAG
import android.util.Log

class UserRepository {
    fun saveUser(email: String, password: String){
        Log.e(TAG, "User $email Saved in DB");
    }
}