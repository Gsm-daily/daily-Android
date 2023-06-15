package com.daily.data.remote.model

import com.daily.domain.model.ImageResponse

data class ImageResponseData(
    val imageUrl: String
)

fun ImageResponseData.asImageResponse() = ImageResponse(
    imageUrl = imageUrl
)