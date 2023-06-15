package com.daily.data.remote.model.response

import com.daily.domain.model.response.ThemeResponse

data class ThemeResponseData(
    val theme: String
)

fun ThemeResponseData.asThemeResponse() = ThemeResponse(
    theme = theme
)