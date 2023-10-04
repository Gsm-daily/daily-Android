package com.daily.domain.usecase.diary

import com.daily.domain.repository.DiaryRepository
import javax.inject.Inject

class GetSeasonUseCase @Inject constructor(
    private val repository: DiaryRepository
) {
    suspend operator fun invoke() = kotlin.runCatching { repository.getSeason() }
}
