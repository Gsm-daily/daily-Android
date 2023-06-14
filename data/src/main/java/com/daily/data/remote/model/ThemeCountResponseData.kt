package com.daily.data.remote.model

import com.daily.domain.model.ThemeCountResponse

data class ThemeCountResponseData(
    val count: Int
)

fun ThemeCountResponseData.asThemeCountResponse() = ThemeCountResponse(
    count = count
)