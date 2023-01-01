package com.example.daggerandroid.modules

import com.example.daggerandroid.NotificationService
import com.example.daggerandroid.SmsService
import dagger.Module
import dagger.Provides

/// A module can be used by a component to get the desired objects
@Module
class NotificationServiceModule {

    /// @Provides tells Dagger that, whenever it needs an element of NotificationService,
    /// it can use the function getSmsService() to create it
    /// rather than creating the element in the body we can let Dagger create the element for us,
    /// as it knows how to instantiate an element for SmsService, i.e calling its constructor,
    /// so, we can change the implementation to this

    @Provides
    fun getSmsService(smsService: SmsService): NotificationService{
        return smsService
    }
}