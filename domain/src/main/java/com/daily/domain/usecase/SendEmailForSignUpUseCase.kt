package com.daily.domain.usecase

import com.daily.domain.repository.EmailRepository
import javax.inject.Inject

class SendEmailForSignUpUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(email: String) = kotlin.runCatching { emailRepository.sendEmailForSignUp(email) }
}