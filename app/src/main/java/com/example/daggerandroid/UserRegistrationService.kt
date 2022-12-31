package com.example.daggerandroid

class UserRegistrationService {
    /// as these variables are closely binded with the class,
    /// so it is hard to test
    /// it does not follow any dependency injection pattern
    private val userRepository = UserRepository();
    private val emailService = EmailService();

    fun resisterUser(email: String, password: String){
        userRepository.saveUser(email, password);
        emailService.send(email, "no-resply@google.com", "body")
    }
}