package com.daily.data.remote.network.api

import com.daily.data.remote.model.request.ProfileRequestData
import com.daily.data.remote.model.response.ProfileResponseData
import com.daily.data.remote.model.request.SelectThemeRequestData
import com.daily.data.remote.model.response.ThemeCountResponseData
import com.daily.data.remote.model.response.ThemeResponseData
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AccountApi {
    @POST("/api/v1/account/choice-theme")
    suspend fun choiceTheme(
        @Body body: SelectThemeRequestData
    )

    @GET("/api/v1/account/theme")
    suspend fun getTheme(): ThemeResponseData

    @GET("/api/v1/account/theme-count/{theme}")
    suspend fun getThemeDiaryCount(
        @Path("theme") theme: String
    ): ThemeCountResponseData

    @GET("/api/v1/account/profile")
    suspend fun getProfile(): ProfileResponseData

    @GET("/api/v1/account/update/profile")
    suspend fun updateProfile(
        @Body body: ProfileRequestData
    )

}