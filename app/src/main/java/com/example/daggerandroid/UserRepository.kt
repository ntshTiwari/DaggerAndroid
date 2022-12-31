package com.example.daggerandroid

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject

/// here we use the [@Inject] annotation, which mean when dagger has to inject this object it can
/// create it using the constructor of the UserRepository class
class UserRepository @Inject constructor() {
    fun saveUser(email: String, password: String){
        Log.e(TAG, "User $email Saved in DB");
    }
}