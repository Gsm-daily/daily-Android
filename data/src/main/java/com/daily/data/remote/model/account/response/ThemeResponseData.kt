package com.daily.data.remote.model.account.response

import com.daily.domain.model.account.response.ThemeResponse

data class ThemeResponseData(
    val theme: String
)

fun ThemeResponseData.asThemeResponse() = ThemeResponse(
    theme = theme
)
