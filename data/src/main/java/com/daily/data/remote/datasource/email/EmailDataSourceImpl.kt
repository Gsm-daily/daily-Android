package com.daily.data.remote.datasource.email

import com.daily.data.remote.model.EmailRequestData
import com.daily.data.remote.model.VerifyAuthKeyRequest
import com.daily.data.remote.network.api.EmailApi
import com.daily.data.remote.util.safeApiCall
import javax.inject.Inject

class EmailDataSourceImpl @Inject constructor(
    private val emailApi: EmailApi
): EmailDataSource {
    override suspend fun sendEmailForSignUp(email: String) {
        safeApiCall { emailApi.sendEmailForSignUp(EmailRequestData(email)) }
    }

    override suspend fun verifyAuthKey(authKey: Int) {
        safeApiCall { emailApi.verifyAuthKey(VerifyAuthKeyRequest(authKey)) }
    }

    override suspend fun sendEmailForPasswordChange(email: String) {
        safeApiCall { emailApi.sendEmailForPasswordChange(EmailRequestData(email)) }
    }
}