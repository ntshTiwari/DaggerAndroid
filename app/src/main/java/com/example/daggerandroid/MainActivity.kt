package com.example.daggerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggerandroid.modules.NotificationServiceModule
import dagger.Component
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /// here we tell dagger that we need this variable through dagger
    /// this is called field injection, it cannot be private
    @Inject
    lateinit var userRegistrationService: UserRegistrationService
    @Inject
    lateinit var emailService: EmailService
    /// as emailService is a singleton, so it will have only one instance
    @Inject
    lateinit var emailService2: EmailService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /// now we can use the Dagger version of the component to build the component
        /// the name of the component will be `Dagger$<interface_name>'
//        val userComponent = DaggerUserComponent.builder()
//            .notificationServiceModule(NotificationServiceModule(3))
//            /// as we need to provide a value (retryCount) to our NotificationServiceModule, so we need to create the module here now
//            .build()

        /// as we are now using a factory method, so we will use the factory method to create the object
        /// all the singleton defined in this component are singleton for this component only,
        /// if we create new component then we will have new instances of the elements
//        val userComponent = DaggerUserComponent.factory().create(3) /// our create method needs a value to change so, we pass it here
        /// one of the benefits of defining a factory method is that, we will know in runtime what values needs to be passed,

        /// after adding application level scope, singleton
        val userComponent = (application as UserApplication).userComponent
        userComponent.inject(this)

        /// then we can use the components to get our instances, dagger will create everything for us
//        val userRegistrationService = userComponent.getUserRegistrationService()
        userRegistrationService.resisterUser("nitesh@mail.com", "password")

//        val emailService = userComponent.getEmailService()
        emailService.send("email@mail", "no-resply@google.com", "body")
    }
}