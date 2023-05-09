package com.daily.data.remote.datasource.account

import com.daily.data.remote.model.ChangePasswordRequestData
import com.daily.data.remote.model.SelectThemeRequestData
import com.daily.data.remote.network.api.AccountApi
import com.daily.data.remote.util.safeApiCall
import javax.inject.Inject

class AccountDataSourceImpl @Inject constructor(
    private val accountApi: AccountApi
) : AccountDataSource {
    override suspend fun choiceTheme(theme: String) {
        safeApiCall { accountApi.choiceTheme(SelectThemeRequestData(theme)) }
    }

    override suspend fun changePassword(changePasswordRequestData: ChangePasswordRequestData) {
        safeApiCall { accountApi.changePassword(changePasswordRequestData) }
    }
}