package com.example.daggerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userRepository = UserRepository();
        val emailService = EmailService();

        /// as we are manually creating objects and passing it to the class, so it follows manual dependency injection
        val userRegistrationService = UserRegistrationService(userRepository, emailService)
        userRegistrationService.resisterUser("nitesh@mail.com", "password")
    }
}