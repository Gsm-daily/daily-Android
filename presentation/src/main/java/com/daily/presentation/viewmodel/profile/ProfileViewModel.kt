package com.daily.presentation.viewmodel.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.diary.response.DiaryResponse
import com.daily.domain.model.image.response.ImageResponse
import com.daily.domain.model.account.request.ProfileRequest
import com.daily.domain.model.account.response.ProfileResponse
import com.daily.domain.usecase.diary.GetAllDiaryUseCase
import com.daily.domain.usecase.account.GetProfileUseCase
import com.daily.domain.usecase.image.ImageUploadUseCase
import com.daily.domain.usecase.account.UpdateProfileUseCase
import com.daily.presentation.viewmodel.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase,
    private val updateProfileUseCase: UpdateProfileUseCase,
    private val getAllDiaryUseCase: GetAllDiaryUseCase,
    private val imageUploadUseCase: ImageUploadUseCase
) : ViewModel() {
    private val _profileUiState = MutableStateFlow<UiState<ProfileResponse>>(UiState.Loading)
    val profileUiState = _profileUiState.asStateFlow()

    private val _diaryUiState = MutableStateFlow<UiState<List<DiaryResponse>>>(UiState.Loading)
    val diaryUiState = _diaryUiState.asStateFlow()

    private val _uploadUiState = MutableStateFlow<UiState<ImageResponse>>(UiState.Loading)
    val uploadUiState = _uploadUiState

    fun getProfile() {
        viewModelScope.launch {
            getProfileUseCase()
                .onSuccess {
                    _profileUiState.value = UiState.Success(it)
                }.onFailure {
                    _profileUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun updateProfile(body: ProfileRequest) {
        viewModelScope.launch {
            updateProfileUseCase(body)
                .onSuccess {

                }.onFailure {

                }
        }
    }

    fun getAllDiary() {
        viewModelScope.launch {
            getAllDiaryUseCase()
                .onSuccess {
                    _diaryUiState.value = UiState.Success(it)
                }.onFailure {
                   _diaryUiState.value = UiState.Error(it.message)
                }
        }
    }

    fun imageUpload(body: MultipartBody.Part) {
        viewModelScope.launch {
            imageUploadUseCase(body)
                .onSuccess {
                    _uploadUiState.value = UiState.Success(it)
                }.onFailure {
                    _uploadUiState.value = UiState.Error(it.message)
                }
        }
    }
}
