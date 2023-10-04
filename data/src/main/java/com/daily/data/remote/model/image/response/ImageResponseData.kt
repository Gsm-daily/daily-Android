package com.daily.data.remote.model.image.response

import com.daily.domain.model.image.response.ImageResponse

data class ImageResponseData(
    val imageUrl: String
)

fun ImageResponseData.asImageResponse() = ImageResponse(
    imageUrl = imageUrl
)
