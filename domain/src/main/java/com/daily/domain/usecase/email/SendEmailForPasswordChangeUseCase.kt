package com.daily.domain.usecase.email

import com.daily.domain.repository.EmailRepository
import javax.inject.Inject

class SendEmailForPasswordChangeUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(email: String) =
        kotlin.runCatching { emailRepository.sendEmailForPasswordChange(email) }
}
