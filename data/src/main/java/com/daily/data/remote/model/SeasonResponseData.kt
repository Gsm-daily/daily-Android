package com.daily.data.remote.model

import com.daily.domain.model.SeasonResponse

data class SeasonResponseData(
    val season: String
)

fun SeasonResponseData.asSeasonResponse() = SeasonResponse(
    season = season
)