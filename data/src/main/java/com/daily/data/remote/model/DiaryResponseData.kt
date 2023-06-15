package com.daily.data.remote.model

import java.time.LocalDateTime

data class DiaryResponseData(
    val content: String,
    val date: LocalDateTime
)
