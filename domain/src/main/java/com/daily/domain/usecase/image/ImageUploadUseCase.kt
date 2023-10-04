package com.daily.domain.usecase.image

import com.daily.domain.repository.ImageRepository
import okhttp3.MultipartBody
import javax.inject.Inject

class ImageUploadUseCase @Inject constructor(
    private val repository: ImageRepository
) {
    suspend operator fun invoke(body: MultipartBody.Part) = kotlin.runCatching { repository.imageUpload(body) }
}
