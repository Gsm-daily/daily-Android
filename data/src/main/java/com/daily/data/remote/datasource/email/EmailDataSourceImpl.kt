package com.daily.data.remote.datasource.email

import com.daily.data.remote.model.email.request.EmailRequestData
import com.daily.data.remote.model.email.request.VerifyAuthKeyRequestData
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
        safeApiCall { emailApi.verifyAuthKey(VerifyAuthKeyRequestData(authKey)) }
    }

    override suspend fun sendEmailForPasswordChange(email: String) {
        safeApiCall { emailApi.sendEmailForPasswordChange(EmailRequestData(email)) }
    }
}
