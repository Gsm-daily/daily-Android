package com.daily.data.repository

import com.daily.data.remote.datasource.image.ImageDataSource
import com.daily.data.remote.model.response.asImageResponse
import com.daily.domain.model.response.ImageResponse
import com.daily.domain.repository.ImageRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(
    private val imageDataSource: ImageDataSource
): ImageRepository {
    override suspend fun imageUpload(body: MultipartBody.Part): ImageResponse = imageDataSource.imageUpload(body).asImageResponse()
}