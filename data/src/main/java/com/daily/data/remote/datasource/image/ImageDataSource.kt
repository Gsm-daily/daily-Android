package com.daily.data.remote.datasource.image

import com.daily.data.remote.model.response.ImageResponseData
import okhttp3.MultipartBody

interface ImageDataSource {
    suspend fun imageUpload(body: MultipartBody.Part): ImageResponseData
}