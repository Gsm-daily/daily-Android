package com.daily.data.remote.model.diary.response

import com.daily.domain.model.response.DiaryResponse
import java.time.LocalDateTime

data class DiaryResponseData(
    val content: String,
    val date: LocalDateTime
)

fun DiaryResponseData.asDiaryResponse() = DiaryResponse(
    content = content,
    date = date
)
