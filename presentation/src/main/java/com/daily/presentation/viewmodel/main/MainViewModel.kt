package com.daily.presentation.viewmodel.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.diary.response.SeasonResponse
import com.daily.domain.usecase.diary.GetSeasonUseCase
import com.daily.presentation.viewmodel.util.UiState
import com.daily.presentation.viewmodel.util.exceptionHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getSeasonUseCase: GetSeasonUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState<SeasonResponse>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun getSeason() {
        viewModelScope.launch {
            getSeasonUseCase()
                .onSuccess { _uiState.value = UiState.Success(it) }
                .onFailure {
                    it.exceptionHandling(
                        unauthorizedAction = { _uiState.value = UiState.Unauthorized },
                        forbiddenAction = { _uiState.value = UiState.Forbidden },
                        notFoundAction = { _uiState.value = UiState.NotFound }
                    )
                }
        }
    }
}
