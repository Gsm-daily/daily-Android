package com.daily.presentation.view.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daily.designsystem.theme.Caption1
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.Subtitle1
import com.daily.domain.model.response.ImageResponse
import com.daily.domain.model.request.ProfileRequest
import com.daily.domain.model.response.ProfileResponse
import com.daily.presentation.R
import com.daily.presentation.viewmodel.profile.ProfileViewModel
import com.daily.presentation.viewmodel.util.UiState
import okhttp3.MultipartBody

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val profileUiState by viewModel.profileUiState.collectAsStateWithLifecycle()
    val diaryUiState by viewModel.diaryUiState.collectAsStateWithLifecycle()
    val uploadUiState by viewModel.uploadUiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getProfile()
    }

    when (val profileState = profileUiState) {
        is UiState.Success -> {
            var profileImage by remember { mutableStateOf(profileState.data!!.profileUrl) }

            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(DailyTheme.color.Background)
                    .systemBarsPadding()
            ) {
                val listState = rememberLazyListState()
                val showShadow by remember {
                    derivedStateOf { listState.firstVisibleItemIndex > 0 }
                }

                DiaryHeader(
                    profile = profileState.data!!,
                    showShadow = showShadow,
                    uploadUiState = uploadUiState,
                    imageUpload = { viewModel.imageUpload(it) }
                ) { url ->
                    val profile = profileState.data

                    viewModel.updateProfile(
                        ProfileRequest(
                            idx = profile.idx,
                            name = profile.name,
                            email = profile.email,
                            profileUrl = url
                        )
                    )
                    profileImage = url
                }

                when (val diaryState = diaryUiState) {
                    is UiState.Success -> {
                        val diary = diaryState.data!!

                        LazyColumn(
                            state = listState,
                            modifier = modifier.padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp),
                            contentPadding = PaddingValues(top = 16.dp)
                        ) {
                            items(diary) {
                                val month = it.date.monthValue
                                val day = it.date.dayOfMonth

                                DiaryItem(title = it.content, date = "${month}월 ${day}일")
                            }
                        }
                    }

                    UiState.Loading -> {}
                    UiState.Unauthorized -> {}
                    else -> {} // 알 수 없는 오류
                }
            }
        }

        UiState.Loading -> {}
        UiState.Unauthorized -> {}
        UiState.NotFound -> {}
        else -> {} // 알 수 없는 오류
    }
}

@Composable
fun DiaryHeader(
    modifier: Modifier = Modifier,
    uploadUiState: UiState<ImageResponse>,
    profile: ProfileResponse,
    showShadow: Boolean,
    imageUpload: (body: MultipartBody.Part) -> Unit,
    updateProfile: (url: String) -> Unit
) {
    when (uploadUiState) {
        is UiState.Success -> updateProfile(uploadUiState.data!!.imageUrl)
        UiState.BadRequest -> {}
        else -> {}
    }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = if (showShadow) 16.dp else 0.dp,
                spotColor = DailyColor.Shadow
            ),
        color = DailyTheme.color.Background
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "profile",
                modifier = modifier.size(80.dp)
            )
            Spacer(modifier = modifier.width(16.dp))
            Column(modifier = modifier.fillMaxWidth()) {
                Subtitle1(text = profile.name)
                Spacer(modifier = modifier.height(8.dp))
                Caption1(
                    text = profile.email,
                    textColor = DailyColor.Neutral30
                )
            }
        }
    }
}

@Composable
fun DiaryItem(
    modifier: Modifier = Modifier,
    title: String,
    date: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DailyTheme.color.White, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = modifier.width(25.dp))
        Text(
            text = date,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = DailyColor.Neutral40,
            maxLines = 1
        )
    }
}