package com.example.daggerandroid.modules

import com.example.daggerandroid.FirebaseRepository
import com.example.daggerandroid.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserRepositoryModule {

    /// @Provides tells Dagger that, whenever it needs an element of UserRepository,
    /// it can use the function getFirebaseRepository() to create it
//    @Provides
//    fun getFirebaseRepository(firebaseRepository: FirebaseRepository): UserRepository {
//        /// we can put our own logic here to create the object, it can be any logic
//        return FirebaseRepository();
//    }

    /// the above `@Provides` method can be changed to `@Binds` method like this
    @Binds
    abstract fun getFirebaseRepository(firebaseRepository: FirebaseRepository): UserRepository;
}