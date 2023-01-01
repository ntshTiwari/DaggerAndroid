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
    @Provides
    fun getSmsService(): NotificationService{
        return SmsService()
    }
}