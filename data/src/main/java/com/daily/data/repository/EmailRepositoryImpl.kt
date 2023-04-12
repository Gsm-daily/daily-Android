package com.daily.data.repository

import com.daily.data.remote.datasource.email.EmailDataSource
import com.daily.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val emailDataSource: EmailDataSource
): EmailRepository {
    override suspend fun sendVerificationCode(email: String) {
        emailDataSource.sendVerificationCode(email)
    }
}