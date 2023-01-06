package com.example.daggerandroid.modules

import com.example.daggerandroid.EmailService
import com.example.daggerandroid.NotificationService
import com.example.daggerandroid.SmsService
import com.example.daggerandroid.annotations.SmsQualifier
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

/// A module can be used by a component to get the desired objects
@Module
class NotificationServiceModule(
    /// we don't need to define this here now, as our @Component is getting created using factory methods, which has this value
//    private val retryCount: Int
 ) {

    /// @Provides tells Dagger that, whenever it needs an element of NotificationService,
    /// it can use the function getSmsService() to create it
    /// rather than creating the element in the body we can let Dagger create the element for us,
    /// as it knows how to instantiate an element for SmsService, i.e calling its constructor,
    /// so, we can change the implementation to this

    /// as there is no body needed, we change the implementation to an abstract and let the passed parameter get returned
    /// For that we will have to use the @Binds keyword
    @Singleton
    @SmsQualifier
    @Provides
    fun getSmsService(retryCount: Int) /// this Int will be passed to it from its Component function now
    : NotificationService {
        return SmsService(retryCount)
    }

    /// we can have more than one function returning the same object, here NotificationService
    /// in this case, to clear any confusion for dagger,
    /// we use @Named annotations, it will be same while defining and consuming
    /// using which dagger will come to know which function/@Provides to use

    @Singleton
    @Named("email")
    @Provides
    fun getEmailService(emailService: EmailService): NotificationService{
        return emailService;
    }
}