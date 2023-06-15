package com.daily.data.repository

import com.daily.data.remote.datasource.diary.DiaryDataSource
import com.daily.data.remote.model.asSeasonResponse
import com.daily.domain.model.SeasonResponse
import com.daily.domain.repository.DiaryRepository
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    private val diaryDataSource: DiaryDataSource
): DiaryRepository {
    override suspend fun getDiary(): SeasonResponse = diaryDataSource.getSeason().asSeasonResponse()
}