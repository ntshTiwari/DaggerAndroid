package com.example.daggerandroid

import com.example.daggerandroid.modules.NotificationServiceModule
import com.example.daggerandroid.modules.UserRepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/// this is a component
/// which will create all the objects for us to use
/// any object we want to use can be returned from here, we just have to create a function returning that object
/// when Dagger will try to create that object, it should know how to create an instance/object of that class
///     the information can be provided to dagger using annotations like @inject and constructor
///     which means when we have to inject that object we can use its constructor to create that object

//// now we pass the modules that will help this component to create the objects it will need
/// in order for the objects to be singleton the component has to be @Singleton as well
@Singleton
@Component(modules = [UserRepositoryModule::class, NotificationServiceModule::class])
interface UserComponent {

    /// we can create a factory component instance, which will now create the `UserComponent` class for us
    @Component.Factory
    interface Factory {
        /// as one of our internal Modules need an integer value to be created, so we accept an Int here, while creating the object
        fun create(@BindsInstance retryCount: Int): UserComponent
    }

    /// here we pass our consumer, in this case it is MainActivity
    ///     and when we do so, dagger will populate all the fields marked as Inject in the consumer
    fun inject(mainActivity: MainActivity)


    //// with this approach, we will have to define functions for all services we need
    //// might be too much task,
    //// so we can use field injection with activity rather than this method
//    /// when anything asks for this object dagger will try to create an object for [UserRegistrationService]
//    /// so, it should be mentioned to dagger on how to create that object
//    fun getUserRegistrationService(): UserRegistrationService
//
//    fun getEmailService(): EmailService
}