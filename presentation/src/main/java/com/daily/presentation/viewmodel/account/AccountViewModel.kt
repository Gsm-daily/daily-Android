package com.daily.presentation.viewmodel.account

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.usecase.ChoiceThemeUseCase
import com.daily.presentation.viewmodel.util.UiState
import com.daily.presentation.viewmodel.util.exceptionHandling
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AccountViewModel @Inject constructor(
    private val choiceThemeUseCase: ChoiceThemeUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    fun choiceTheme(theme: String) {
        viewModelScope.launch {
            choiceThemeUseCase(theme)
                .onSuccess {
                    _uiState.value = UiState.Success
                }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { _uiState.value = UiState.BadRequest },
                        unauthorizedAction = { _uiState.value = UiState.Unauthorized },
                        forbiddenAction = { _uiState.value = UiState.Forbidden },
                        notFoundAction = { _uiState.value = UiState.NotFound },
                        conflictAction = { _uiState.value = UiState.Conflict },
                        unknownAction = { _uiState.value = UiState.Unknown }
                    )
                }
        }
    }
}