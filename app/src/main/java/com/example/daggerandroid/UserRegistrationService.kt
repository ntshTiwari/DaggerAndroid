package com.example.daggerandroid

/// now the parameters can be passed to this class
/// so, now they are not closely binded
class UserRegistrationService(
    private val userRepository: UserRepository,
    private val emailService: EmailService,
) {
    fun resisterUser(email: String, password: String){
        userRepository.saveUser(email, password);
        emailService.send(email, "no-resply@google.com", "body")
    }
}