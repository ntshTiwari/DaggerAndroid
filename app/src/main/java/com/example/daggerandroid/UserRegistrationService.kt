package com.example.daggerandroid

import com.example.daggerandroid.annotations.SmsQualifier
import javax.inject.Inject
import javax.inject.Named

/// now the parameters can be passed to this class
/// so, now they are not closely binded

/// here we use the [@Inject] annotation, which mean when dagger has to inject this object it can
/// create it using the constructor of the UserRegistrationService class

/// As we cannot create objects of UserRepository & EmailService with the constructor,
/// so, we need to tell Dagger how to create their objects
class UserRegistrationService @Inject constructor(
    private val userRepository: UserRepository,
    /// even while consuming, we need to mention the @Named annotation with the name, to let dagger know what do we want to consume
    @SmsQualifier private val notificationService: NotificationService,
) /// this is called constructor injection
{
    fun resisterUser(email: String, password: String){
        userRepository.saveUser(email, password);
        notificationService.send(email, "no-resply@google.com", "body")
    }
}