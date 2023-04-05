package com.daily.presentation.view.auth.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.daily.designsystem.component.DailyButton
import com.daily.designsystem.theme.Caption1
import com.daily.designsystem.theme.DailyTheme
import com.daily.presentation.R
import com.daily.presentation.view.auth.PasswordField

@Composable
fun PasswordInput(
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var isPasswordMatched by remember { mutableStateOf(true) }

    Column(modifier = modifier.fillMaxWidth()) {
        PasswordField(
            modifier = modifier.defaultMinSize(minHeight = 24.dp),
            hint = stringResource(R.string.enter_the_password),
            leadingIconEnabled = false
        ) {
            password = it
        }
        Spacer(modifier = modifier.height(12.dp))
        PasswordField(
            modifier = modifier.defaultMinSize(minHeight = 24.dp),
            hint = stringResource(R.string.enter_the_confirm_password),
            leadingIconEnabled = false
        ) {
            confirmPassword = it
        }
        if (!isPasswordMatched) {
            Caption1(
                text = stringResource(R.string.confirm_password_does_not_match),
                textColor = DailyTheme.color.Error,
                modifier = modifier.padding(horizontal = 8.dp, vertical = 12.dp)
            )
        }
        Spacer(modifier = modifier.height(if (isPasswordMatched) 82.dp else 44.dp))
        DailyButton(
            text = stringResource(R.string.next),
            modifier = modifier.fillMaxWidth()
        ) {
            isPasswordMatched = if (password.isEmpty()) false else password == confirmPassword
            if (isPasswordMatched) onNext()
        }
    }
}