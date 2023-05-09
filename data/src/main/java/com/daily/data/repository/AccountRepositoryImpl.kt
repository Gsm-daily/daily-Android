package com.daily.data.repository

import com.daily.data.remote.datasource.account.AccountDataSource
import com.daily.data.remote.model.asChangePasswordRequest
import com.daily.domain.model.ChangePasswordRequest
import com.daily.domain.repository.AccountRepository
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountDataSource: AccountDataSource
): AccountRepository {
    override suspend fun choiceTheme(theme: String) {
        accountDataSource.choiceTheme(theme)
    }

    override suspend fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        accountDataSource.changePassword(changePasswordRequest.asChangePasswordRequest())
    }
}