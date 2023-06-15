package com.daily.data.remote.model.response

import com.daily.domain.model.response.ThemeCountResponse

data class ThemeCountResponseData(
    val count: Int
)

fun ThemeCountResponseData.asThemeCountResponse() = ThemeCountResponse(
    count = count
)