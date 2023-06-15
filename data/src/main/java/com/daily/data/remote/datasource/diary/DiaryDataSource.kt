package com.daily.data.remote.datasource.diary

import com.daily.data.remote.model.response.DiaryResponseData
import com.daily.data.remote.model.response.SeasonResponseData

interface DiaryDataSource {
    suspend fun getSeason(): SeasonResponseData
    suspend fun getAllDiary(): List<DiaryResponseData>
}