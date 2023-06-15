package com.daily.data.remote.network.api

import com.daily.data.remote.model.DiaryResponseData
import com.daily.data.remote.model.SeasonResponseData
import retrofit2.http.GET

interface DiaryApi {
    @GET("/api/v1/diary/season")
    suspend fun getSeason(): SeasonResponseData

    @GET("/api/v1/diary")
    suspend fun getAllDiary(): List<DiaryResponseData>
}