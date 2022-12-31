package com.example.daggerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// now we can use the Dagger version of the component to build the component
        /// the name of the component will be `Dagger$<interface_name>'
        val userComponent = DaggerUserComponent.builder().build()

        /// then we can use the components to get our instances, dagger will create everything for us
        val userRegistrationService = userComponent.getUserRegistrationService()
        userRegistrationService.resisterUser("nitesh@mail.com", "password")

        val emailService = userComponent.getEmailService()
        emailService.send("email@mail", "no-resply@google.com", "body")
    }
}