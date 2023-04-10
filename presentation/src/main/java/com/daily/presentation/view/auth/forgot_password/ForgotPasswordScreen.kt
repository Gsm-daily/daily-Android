package com.daily.presentation.view.auth.forgot_password

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.*
import com.daily.presentation.R
import com.daily.presentation.view.auth.component.EmailInput
import com.daily.presentation.view.auth.component.PasswordInput

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    email: String?,
    navigateToPrevious: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToVerification: (String) -> Unit
) {
    val step by remember { mutableStateOf(if (email == null) ForgotPasswordState.EmailInput else ForgotPasswordState.PasswordInput) }

    val description = when (step) {
        ForgotPasswordState.EmailInput -> R.string.email_authentication
        ForgotPasswordState.PasswordInput -> R.string.enter_the_new_password
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
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = modifier.height(24.dp))
            H1(
                text = stringResource(R.string.find_password)
            )
            Spacer(modifier = modifier.height(8.dp))
            Body2(
                text = stringResource(description),
                textColor = DailyTheme.color.Neutral50
            )
            Spacer(modifier = modifier.height(24.dp))

            when (step) {
                ForgotPasswordState.EmailInput -> EmailInput { navigateToVerification(it) }
                ForgotPasswordState.PasswordInput -> PasswordInput { }
            }

            Spacer(modifier = modifier.height(16.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Caption1(
                    text = stringResource(R.string.password_change_not_required),
                    textColor = DailyTheme.color.Neutral40
                )
                Spacer(modifier = modifier.width(4.dp))
                Caption2(
                    text = stringResource(R.string.login),
                    textColor = DailyTheme.color.Primary20,
                    rippleEnabled = false,
                    onClick = { navigateToLogin() }
                )
            }
        }
    }
}