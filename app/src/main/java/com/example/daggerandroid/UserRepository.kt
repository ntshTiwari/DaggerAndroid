package com.example.daggerandroid

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

/// using interface we can implement a loosely coupled architecture
/// with which we can pass different classes based on the requirements
interface UserRepository{
    fun saveUser(email: String, password: String)
}

/// here we use the [@Inject] annotation, which mean when dagger has to inject this object it can
/// create it using the constructor of the UserRepository class
class SQLRepository @Inject constructor(): UserRepository {
    override fun saveUser(email: String, password: String){
        Log.e(TAG, "User $email Saved in SQL DB");
    }
}

@Singleton
class FirebaseRepository @Inject constructor(): UserRepository {
    override fun saveUser(email: String, password: String){
        Log.e(TAG, "User $email Saved in Firebase DB");
    }
}