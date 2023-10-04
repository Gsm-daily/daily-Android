package com.daily.presentation.viewmodel.profile

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daily.domain.model.diary.response.DiaryResponse
import com.daily.domain.model.image.response.ImageResponse
import com.daily.domain.model.account.request.ProfileRequest
import com.daily.domain.model.account.response.ProfileResponse
import com.daily.domain.usecase.GetAllDiaryUseCase
import com.daily.domain.usecase.GetProfileUseCase
import com.daily.domain.usecase.ImageUploadUseCase
import com.daily.domain.usecase.UpdateProfileUseCase
import com.daily.presentation.viewmodel.util.UiState
import com.daily.presentation.viewmodel.util.exceptionHandling
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
                }
                .onFailure {
                    it.exceptionHandling(
                        unauthorizedAction = { _profileUiState.value = UiState.Unauthorized },
                        notFoundAction = { _profileUiState.value = UiState.NotFound }
                    )
                }
        }
    }

    fun updateProfile(body: ProfileRequest) {
        viewModelScope.launch {
            updateProfileUseCase(body)
                .onSuccess {
                    Log.d("updateProfile", "success")
                }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { Log.d("updateProfile", "badRequest") },
                        unauthorizedAction = { Log.d("updateProfile", "unauthorized") },
                        notFoundAction = { Log.d("updateProfile", "notFound") }
                    )
                }
        }
    }

    fun getAllDiary() {
        viewModelScope.launch {
            getAllDiaryUseCase()
                .onSuccess {
                    _diaryUiState.value = UiState.Success(it)
                }
                .onFailure {
                    it.exceptionHandling(
                        unauthorizedAction = { _diaryUiState.value = UiState.Unauthorized }
                    )
                }
        }
    }

    fun imageUpload(body: MultipartBody.Part) {
        viewModelScope.launch {
            imageUploadUseCase(body)
                .onSuccess {
                    _uploadUiState.value = UiState.Success(it)
                }
                .onFailure {
                    it.exceptionHandling(
                        badRequestAction = { _uploadUiState.value = UiState.BadRequest }
                    )
                }
        }
    }
}
