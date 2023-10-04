package com.daily.presentation.view.auth.signin

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.daily.designsystem.component.button.DailyButton
import com.daily.designsystem.theme.*
import com.daily.presentation.R
import com.daily.designsystem.component.EmailField
import com.daily.designsystem.component.PasswordField

@Composable
fun SignInField(
    modifier: Modifier = Modifier,
    signIn: (String, String) -> Unit,
    navigateToForgotPassword: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf<Boolean?>(null) }
    var isPasswordBlank by remember { mutableStateOf<Boolean?>(null) }
    var buttonEnabled by remember { mutableStateOf(false) }

    buttonEnabled = isEmailValid == true && isPasswordBlank == false

    Column(modifier = modifier.fillMaxWidth()) {
        EmailField(
            hint = stringResource(R.string.enter_the_email),
            leadingIconEnabled = true,
            trailingIconEnabled = true
        ) {
            isEmailValid = if (it.isEmpty()) true else EMAIL_ADDRESS.matcher(it).matches()
            email = it
        }

        isEmailValid?.let { isEmailValid ->
            if (!isEmailValid) {
                Caption1(
                    text = stringResource(R.string.email_format_not_valid),
                    textColor = DailyTheme.color.Error,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp)
                )
            }
        }
        Spacer(modifier = modifier.height(12.dp))
        PasswordField(
            hint = stringResource(R.string.enter_the_password)
        ) {
            isPasswordBlank = it.isEmpty()
            password = it
        }
        Spacer(modifier = modifier.height(12.dp))
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            isPasswordBlank?.let { isPasswordBlank ->
                if (isPasswordBlank) {
                    Caption1(
                        text = stringResource(R.string.password_is_blank),
                        textColor = DailyTheme.color.Error
                    )
                    Spacer(modifier = modifier.weight(1f))
                }
            }
            Caption1(
                text = stringResource(R.string.forgot_password),
                textColor = DailyTheme.color.Neutral40,
                rippleEnabled = false,
                onClick = { navigateToForgotPassword() }
            )
        }
        Spacer(
            modifier = modifier.height(
                when (isPasswordBlank) {
                    null -> 26.dp
                    else -> 56.dp
                }
            )
        )
        DailyButton(
            text = stringResource(R.string.login),
            modifier = modifier.fillMaxWidth(),
            enabled = buttonEnabled,
            onClick = { signIn(email, password) }
        )
    }
}
