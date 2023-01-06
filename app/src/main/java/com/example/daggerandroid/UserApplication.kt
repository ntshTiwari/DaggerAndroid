package com.example.daggerandroid

import android.app.Application

class UserApplication: Application() {

    lateinit var userComponent: UserComponent

    override fun onCreate() {
        super.onCreate()

        userComponent = DaggerUserComponent.factory().create(3)
    }
}