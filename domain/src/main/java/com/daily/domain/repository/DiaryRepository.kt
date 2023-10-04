package com.daily.domain.repository

import com.daily.domain.model.diary.response.DiaryResponse
import com.daily.domain.model.diary.response.SeasonResponse

interface DiaryRepository {
    suspend fun getSeason(): SeasonResponse
    suspend fun getAllDiary(): List<DiaryResponse>
}
