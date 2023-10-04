package com.daily.domain.usecase.email

import com.daily.domain.repository.EmailRepository
import javax.inject.Inject

class VerifyAuthKeyUseCase @Inject constructor(
    private val emailRepository: EmailRepository
) {
    suspend operator fun invoke(authKey: Int) = kotlin.runCatching { emailRepository.verifyAuthKey(authKey)  }
}
