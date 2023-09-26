package com.daily.data.remote.datasource.image

import com.daily.data.remote.network.api.ImageApi
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageDataSourceImpl @Inject constructor(
    private val imageApi: ImageApi
): ImageDataSource {
    override suspend fun imageUpload(body: MultipartBody.Part) = imageApi.imageUpload(body)
}
