package com.daily.data.repository

import com.daily.data.remote.datasource.diary.DiaryDataSource
import com.daily.data.remote.model.diary.response.asDiaryResponse
import com.daily.data.remote.model.diary.response.asSeasonResponse
import com.daily.domain.model.response.DiaryResponse
import com.daily.domain.model.response.SeasonResponse
import com.daily.domain.repository.DiaryRepository
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val diaryDataSource: DiaryDataSource
): DiaryRepository {
    override suspend fun getSeason(): SeasonResponse = diaryDataSource.getSeason().asSeasonResponse()

    override suspend fun getAllDiary(): List<DiaryResponse> = diaryDataSource.getAllDiary().map { it.asDiaryResponse() }
}
