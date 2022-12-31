package com.example.daggerandroid

import dagger.Component

/// this is a component
/// which will create all the objects for us to use
/// any object we want to use can be returned from here, we just have to create a function returning that object
/// when Dagger will try to create that object, it should know how to create an instance/object of that class
///     the information can be provided to dagger using annotations like @inject and constructor
///     which means when we have to inject that object we can use its constructor to create that object

@Component
interface UserComponent {

    /// when anything asks for this object dagger will try to create an object for [UserRegistrationService]
    /// so, it should be mentioned to dagger on how to create that object
    fun getUserRegistrationService(): UserRegistrationService

    fun getEmailService(): EmailService
}