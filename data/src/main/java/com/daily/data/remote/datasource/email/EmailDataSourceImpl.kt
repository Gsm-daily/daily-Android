package com.daily.data.remote.datasource.email

import com.daily.data.remote.network.api.EmailApi
import javax.inject.Inject

class EmailDataSourceImpl @Inject constructor(
    private val emailApi: EmailApi
): EmailDataSource {
    override suspend fun sendEmailForSignUp(email: String) {
        emailApi.sendEmailForSignUp(email)
    }

    override suspend fun verifyAuthKey(authKey: Int) {
        emailApi.verifyAuthKey(authKey)
    }

    override suspend fun sendEmailForPasswordChange(email: String) {
        emailApi.sendEmailForPasswordChange(email)
    }
}