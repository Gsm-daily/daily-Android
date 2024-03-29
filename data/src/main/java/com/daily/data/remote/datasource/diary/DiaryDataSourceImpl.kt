package com.daily.data.remote.datasource.diary

import com.daily.data.remote.model.diary.response.DiaryResponseData
import com.daily.data.remote.model.diary.response.SeasonResponseData
import com.daily.data.remote.network.api.DiaryApi
import javax.inject.Inject

class DiaryDataSourceImpl @Inject constructor(
    private val diaryApi: DiaryApi
): DiaryDataSource {
    override suspend fun getSeason(): SeasonResponseData = diaryApi.getSeason()
    override suspend fun getAllDiary(): List<DiaryResponseData> = diaryApi.getAllDiary()
}
