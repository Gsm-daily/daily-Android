package com.daily.data.repository

import com.daily.data.remote.datasource.email.EmailDataSource
import com.daily.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val emailDataSource: EmailDataSource
): EmailRepository {
    override suspend fun sendEmailForSignUp(email: String) {
        emailDataSource.sendEmailForSignUp(email)
    }

    override suspend fun verifyAuthKey(authKey: Int) {
        emailDataSource.verifyAuthKey(authKey)
    }
}