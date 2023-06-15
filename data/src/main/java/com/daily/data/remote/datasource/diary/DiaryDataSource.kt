package com.daily.data.remote.datasource.diary

import com.daily.data.remote.model.DiaryResponseData
import com.daily.data.remote.model.SeasonResponseData

interface DiaryDataSource {
    suspend fun getSeason(): SeasonResponseData
    suspend fun getAllDiary(): List<DiaryResponseData>
}