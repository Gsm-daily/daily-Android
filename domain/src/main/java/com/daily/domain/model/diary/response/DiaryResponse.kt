package com.daily.domain.model.diary.response

import java.time.LocalDateTime

data class DiaryResponse(
    val content: String,
    val date: LocalDateTime
)
