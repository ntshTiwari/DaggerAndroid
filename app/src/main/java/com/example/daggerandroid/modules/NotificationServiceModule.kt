package com.example.daggerandroid.modules

import com.example.daggerandroid.EmailService
import com.example.daggerandroid.NotificationService
import com.example.daggerandroid.SmsService
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named

/// A module can be used by a component to get the desired objects
@Module
class NotificationServiceModule {

    /// @Provides tells Dagger that, whenever it needs an element of NotificationService,
    /// it can use the function getSmsService() to create it
    /// rather than creating the element in the body we can let Dagger create the element for us,
    /// as it knows how to instantiate an element for SmsService, i.e calling its constructor,
    /// so, we can change the implementation to this

    /// as there is no body needed, we change the implementation to an abstract and let the passed parameter get returned
    /// For that we will have to use the @Binds keyword
    @Named("sms")
    @Provides
    fun getSmsService(smsService: SmsService): NotificationService {
        return smsService
    }

    /// we can have more than one function returning the same object, here NotificationService
    /// in this case, to clear any confusion for dagger,
    /// we use @Named annotations, it will be same while defining and consuming
    /// using which dagger will come to know which function/@Provides to use

    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService): NotificationService{
        return emailService;
    }
}