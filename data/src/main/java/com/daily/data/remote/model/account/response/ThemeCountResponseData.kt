package com.daily.data.remote.model.account.response

import com.daily.domain.model.account.response.ThemeCountResponse

data class ThemeCountResponseData(
    val count: Int
)

fun ThemeCountResponseData.asThemeCountResponse() = ThemeCountResponse(
    count = count
)
