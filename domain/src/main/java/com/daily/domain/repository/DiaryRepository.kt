package com.daily.domain.repository

import com.daily.domain.model.response.DiaryResponse
import com.daily.domain.model.response.SeasonResponse

interface DiaryRepository {
    suspend fun getSeason(): SeasonResponse
    suspend fun getAllDiary(): List<DiaryResponse>
}