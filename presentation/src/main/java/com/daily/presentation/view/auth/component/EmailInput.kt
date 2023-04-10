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

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    onNext: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf<Boolean?>(null) }
    var buttonEnabled by remember { mutableStateOf(false) }

    isEmailValid?.let { buttonEnabled = it }

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
        Spacer(
            modifier = modifier.height(
                when (isEmailValid) {
                    false -> 116.dp
                    else -> 154.dp
                }
            )
        )

        DailyButton(
            text = stringResource(R.string.get_verification_code),
            enabled = buttonEnabled,
            modifier = modifier.fillMaxWidth()
        ) {
            isEmailValid = if (email.isEmpty()) false else PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
            isEmailValid?.let { isEmailValid -> if (isEmailValid) onNext(email) }
        }
    }
}