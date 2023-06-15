package com.daily.data.remote.model.response

import com.daily.domain.model.response.SeasonResponse

data class SeasonResponseData(
    val season: String
)

fun SeasonResponseData.asSeasonResponse() = SeasonResponse(
    season = season
)