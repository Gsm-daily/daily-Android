package com.daily.data.remote.network.api

import com.daily.data.remote.model.SelectThemeRequestData
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountApi {
    @POST("/api/v1/account/choice-theme")
    suspend fun choiceTheme(
        @Body body: SelectThemeRequestData
    )
}