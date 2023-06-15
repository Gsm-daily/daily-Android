package com.daily.domain.usecase

import com.daily.domain.repository.DiaryRepository
import javax.inject.Inject

class GetAllDiaryUseCase @Inject constructor(
    private val repository: DiaryRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { repository.getAllDiary() }
}