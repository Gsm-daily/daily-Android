package com.daily.data.remote.datasource.diary

import com.daily.data.remote.model.SeasonResponseData

interface DiaryDataSource {
    suspend fun getSeason(): SeasonResponseData
}