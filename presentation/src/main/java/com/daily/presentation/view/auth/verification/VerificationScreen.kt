package com.daily.presentation.view.auth.verification

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.*
import com.daily.presentation.R
import com.daily.presentation.view.auth.component.Timer
import com.daily.presentation.viewmodel.email.EmailViewModel
import com.daily.presentation.viewmodel.util.UiState

private const val CODE_LENGTH = 4

@Composable
fun VerificationScreen(
    modifier: Modifier = Modifier,
    email: String?,
    type: String?,
    viewModel: EmailViewModel = hiltViewModel(),
    navigateToPrevious: () -> Unit,
    navigateToNext: (String) -> Unit
) {
    var code by remember { mutableStateOf("") }
    var isMatched by remember { mutableStateOf(true) }
    var isComplete by remember { mutableStateOf(false) }

    val uiState by viewModel.verifyUiState.collectAsStateWithLifecycle()

    when (uiState) {
        is UiState.Success -> navigateToNext(checkNotNull(email))
        UiState.Loading -> {}
        UiState.BadRequest -> isMatched = false
        else -> {} // 알 수 없는 오류
    }

    LaunchedEffect(Unit) {
        viewModel.startTimer(300L)
        when (type) {
            "signup" -> {
                if (email != null) {
                    viewModel.sendEmailForSignUp(email)
                }
            }
            "password" -> viewModel.sendEmailForPasswordChange(checkNotNull(email))
        }
    }

    Column(modifier = modifier.systemBarsPadding()) {
        IcBack(
            contentDescription = "back",
            tint = DailyTheme.color.Black,
            modifier = modifier
                .padding(start = 16.dp, top = 8.dp)
                .dailyClickable(rippleEnable = false) { navigateToPrevious() }
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val duration by viewModel.remainingTime.collectAsStateWithLifecycle()

            Spacer(modifier = modifier.height(48.dp))
            Timer(duration = duration)
            Spacer(modifier = modifier.height(8.dp))
            Body3(
                text = stringResource(R.string.verification_code_sent),
                textAlign = TextAlign.Center,
                textColor = DailyTheme.color.Neutral40
            )
            Spacer(modifier = modifier.height(32.dp))
            VerificationTextField(
                value = code,
                length = CODE_LENGTH,
                onValueChange = {
                    isComplete = false
                    if (it.length <= CODE_LENGTH) {
                        code = it
                    }
                    if (code.length == CODE_LENGTH) {
                        viewModel.verifyAuthKey(code.toInt())
                        isComplete = true
                    }
                }
            )
            if (!isMatched && isComplete) {
                Spacer(modifier = modifier.height(12.dp))
                Caption1(
                    text = stringResource(R.string.verification_code_not_matching),
                    textColor = DailyTheme.color.Error,
                    rippleEnabled = false
                )
            }
            Spacer(modifier = modifier.height(16.dp))
            Caption2(
                text = stringResource(R.string.resend),
                textColor = DailyTheme.color.Primary20,
                rippleEnabled = false,
                onClick = {
                    when (checkNotNull(type)) {
                        "signup" -> viewModel.sendEmailForSignUp(checkNotNull(email))
                        "password" -> viewModel.sendEmailForPasswordChange(checkNotNull(email))
                    }
                }
            )
        }
    }
}