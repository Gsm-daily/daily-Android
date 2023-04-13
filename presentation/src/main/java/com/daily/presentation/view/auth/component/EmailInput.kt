package com.daily.presentation.view.auth.component

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.util.PatternsCompat
import com.daily.designsystem.component.DailyButton
import com.daily.designsystem.theme.Caption1
import com.daily.designsystem.theme.DailyTheme
import com.daily.presentation.R
import com.daily.designsystem.component.EmailField
import com.daily.presentation.viewmodel.util.UiState

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    state: UiState? = null,
    checkDuplicateEmail: ((String) -> Unit)? = null,
    onNext: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf<Boolean?>(null) }
    var isEmailUnique by remember { mutableStateOf<Boolean?>(null) }
    var buttonEnabled by remember { mutableStateOf(false) }

    isEmailValid?.let { buttonEnabled = it }

    if (state != null) {
        when (state) {
            UiState.Success -> isEmailUnique = true
            UiState.Conflict -> isEmailUnique = false
            UiState.Loading -> {}
            else -> {} // 알 수 없는 오류
        }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        EmailField(
            modifier = modifier.defaultMinSize(minHeight = 24.dp),
            hint = stringResource(R.string.enter_the_email),
            leadingIconEnabled = false
        ) {
            email = it
            isEmailValid = PatternsCompat.EMAIL_ADDRESS.matcher(it).matches()
        }
        isEmailValid?.let { isEmailValid ->
            if (!isEmailValid) {
                Caption1(
                    text = stringResource(R.string.email_format_not_valid),
                    textColor = DailyTheme.color.Error,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
                )
            }
        }
        isEmailUnique?.let { isEmailUnique ->
            if (!isEmailUnique) {
                Caption1(
                    text = stringResource(R.string.email_is_already_exist),
                    textColor = DailyTheme.color.Error,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
                )
            }
        }
        Spacer(
            modifier = modifier.height(
                if (isEmailValid == false || isEmailUnique == false) 116.dp else 154.dp
            )
        )
        DailyButton(
            text = stringResource(R.string.get_verification_code),
            enabled = buttonEnabled,
            modifier = modifier.fillMaxWidth()
        ) {
            isEmailValid = if (email.isEmpty()) false else PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
            isEmailValid?.let { isEmailValid ->
                when {
                    isEmailValid && isEmailUnique == true -> onNext(email)
                    isEmailValid -> if (checkDuplicateEmail != null) checkDuplicateEmail(email)
                }
            }
        }
    }
}