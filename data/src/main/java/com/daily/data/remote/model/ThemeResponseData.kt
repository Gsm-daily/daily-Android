package com.daily.data.remote.model

import com.daily.domain.model.ThemeResponse

data class ThemeResponseData(
    val theme: String
)

fun ThemeResponseData.asThemeResponse() = ThemeResponse(
    theme = theme
)