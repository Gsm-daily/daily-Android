package com.daily.domain.repository

import com.daily.domain.model.DiaryResponse
import com.daily.domain.model.SeasonResponse

interface DiaryRepository {
    suspend fun getDiary(): SeasonResponse
    suspend fun getAllDiary(): List<DiaryResponse>
}