package com.daily.domain.model

import java.time.LocalDateTime

data class DiaryResponse(
    val content: String,
    val date: LocalDateTime
)
