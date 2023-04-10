package com.daily.presentation.view.auth.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.*
import com.daily.presentation.R
import com.daily.presentation.view.auth.component.EmailInput
import com.daily.presentation.view.auth.component.PasswordInput

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    email: String?,
    navigateToPrevious: () -> Unit,
    navigateToLogin: () -> Unit,
    navigateToVerification: (String) -> Unit,
    navigateToSelectTheme: () -> Unit
) {
    var step by remember { mutableStateOf(if (email == null) EmailInput else PasswordInput) }

    val description = when (step) {
        EmailInput -> R.string.email_authentication
        NicknameInput -> R.string.enter_the_nickname
        PasswordInput -> R.string.enter_the_password
    }

    Column(modifier = modifier.systemBarsPadding()) {
        IcBack(
            contentDescription = "back",
            tint = DailyTheme.color.Black,
            modifier = modifier
                .padding(start = 16.dp, top = 8.dp)
                .dailyClickable(rippleEnable = false) {
                    when (step) {
                        EmailInput -> navigateToPrevious()
                        else -> {
                            email?.let { navigateToPrevious() } ?: {
                                step = step.previous()
                            }
                        }
                    }
                }
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Spacer(modifier = modifier.height(24.dp))
            H1(
                text = stringResource(R.string.sign_up)
            )
            Spacer(modifier = modifier.height(8.dp))
            Body2(
                text = stringResource(description),
                textColor = DailyTheme.color.Neutral50
            )
            Spacer(modifier = modifier.height(24.dp))

            when (step) {
                EmailInput -> EmailInput { navigateToVerification(it) }
                NicknameInput -> NicknameInput { navigateToSelectTheme() }
                PasswordInput -> PasswordInput { step = step.next() }
            }

            Spacer(modifier = modifier.height(16.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Caption1(
                    text = stringResource(R.string.already_have_an_account),
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