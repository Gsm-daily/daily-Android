package com.daily.data.remote.model

import com.daily.domain.model.DiaryResponse
import java.time.LocalDateTime

data class DiaryResponseData(
    val content: String,
    val date: LocalDateTime
)

fun DiaryResponseData.asDiaryResponse() = DiaryResponse(
    content = content,
    date = date
)
