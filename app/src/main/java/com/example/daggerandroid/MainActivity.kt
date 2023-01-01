package com.example.daggerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /// here we tell dagger that we need this variable through dagger
    /// this is called field injection, it cannot be private
    @Inject
    lateinit var userRegistrationService: UserRegistrationService
    @Inject
    lateinit var emailService: EmailService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// now we can use the Dagger version of the component to build the component
        /// the name of the component will be `Dagger$<interface_name>'
        val userComponent = DaggerUserComponent.builder().build()
        userComponent.inject(this)

        /// then we can use the components to get our instances, dagger will create everything for us
//        val userRegistrationService = userComponent.getUserRegistrationService()
        userRegistrationService.resisterUser("nitesh@mail.com", "password")

//        val emailService = userComponent.getEmailService()
        emailService.send("email@mail", "no-resply@google.com", "body")
    }
}