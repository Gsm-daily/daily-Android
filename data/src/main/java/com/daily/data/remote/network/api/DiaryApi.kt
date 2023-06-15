package com.daily.data.remote.network.api

import com.daily.data.remote.model.SeasonResponseData
import retrofit2.http.GET

interface DiaryApi {
    @GET("/api/v1/diary/season")
    fun getSeason(): SeasonResponseData
}