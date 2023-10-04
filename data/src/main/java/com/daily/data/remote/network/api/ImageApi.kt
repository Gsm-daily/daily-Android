package com.daily.data.remote.network.api

import com.daily.data.remote.model.image.response.ImageResponseData
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImageApi {
    @Multipart
    @POST("/api/v1/image")
    suspend fun imageUpload(
        @Part file: MultipartBody.Part
    ): ImageResponseData
}
