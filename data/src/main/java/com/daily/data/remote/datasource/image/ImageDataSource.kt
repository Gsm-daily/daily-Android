package com.daily.data.remote.datasource.image

import com.daily.data.remote.model.ImageResponseData
import okhttp3.MultipartBody

interface ImageDataSource {
    suspend fun imageUpload(body: MultipartBody.Part): ImageResponseData
}