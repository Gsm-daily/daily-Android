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
    type: String,
    checkDuplicateEmail: (String) -> Unit = {},
    onNext: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf<Boolean?>(null) }
    var isEmailUnique by remember { mutableStateOf<Boolean?>(null) }
    var onClicked by remember { mutableStateOf(false) }

    if (state != null) {
        when (state) {
            UiState.Success -> isEmailUnique = true
            UiState.Conflict -> isEmailUnique = false
            UiState.Loading -> {}
            else -> {} // 알 수 없는 오류
        }
    }

    val errorRes = when {
        isEmailValid == false -> R.string.email_format_not_valid
        isEmailUnique == false -> R.string.email_is_already_exist
        else -> null
    }

    if (isEmailValid == true && isEmailUnique == true && onClicked) {
        onNext(email)
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
        errorRes?.let {
            Caption1(
                text = stringResource(it),
                textColor = DailyTheme.color.Error,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
            )
        }
        Spacer(modifier = modifier.height(if (errorRes != null) 116.dp else 154.dp))
        DailyButton(
            text = stringResource(R.string.get_verification_code),
            enabled = isEmailValid ?: false,
            modifier = modifier.fillMaxWidth()
        ) {
            if (isEmailValid == true) {
                when (type) {
                    "signup" -> {
                        checkDuplicateEmail(email)
                        onClicked = true
                    }
                    "password" -> {}
                }
            }
        }
    }
}