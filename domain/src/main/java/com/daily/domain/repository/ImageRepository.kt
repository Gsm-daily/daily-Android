package com.daily.domain.repository

import com.daily.domain.model.ImageResponse
import okhttp3.MultipartBody

interface ImageRepository {
    suspend fun imageUpload(body: MultipartBody.Part): ImageResponse
}