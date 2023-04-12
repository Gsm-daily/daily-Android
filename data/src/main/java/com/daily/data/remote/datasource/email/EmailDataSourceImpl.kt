package com.daily.data.remote.datasource.email

import com.daily.data.remote.network.api.EmailApi
import javax.inject.Inject

class EmailDataSourceImpl @Inject constructor(
    private val emailApi: EmailApi
): EmailDataSource {
    override suspend fun sendVerificationCode(email: String) {
        emailApi.sendVerificationCode(email)
    }
}