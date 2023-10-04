package com.daily.data.remote.datasource.diary

import com.daily.data.remote.model.diary.response.DiaryResponseData
import com.daily.data.remote.model.diary.response.SeasonResponseData

interface DiaryDataSource {
    suspend fun getSeason(): SeasonResponseData
    suspend fun getAllDiary(): List<DiaryResponseData>
}
