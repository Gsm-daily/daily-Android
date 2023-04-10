package com.daily.presentation.view.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.daily.presentation.R
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.*

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navigateToPrevious: () -> Unit,
    navigateToSignUp: () -> Unit,
    navigateToForgotPassword: () -> Unit
) {
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
                text = stringResource(R.string.login)
            )
            Spacer(modifier = modifier.height(8.dp))
            Body2(
                text = stringResource(R.string.welcome_to_back),
                textColor = DailyTheme.color.Neutral50
            )
            Spacer(modifier = modifier.height(24.dp))
            LoginField { navigateToForgotPassword() }
            Spacer(modifier = modifier.height(16.dp))
            Row(
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Caption1(
                    text = stringResource(R.string.first_time_to_daily),
                    textColor = DailyTheme.color.Neutral40
                )
                Spacer(modifier = modifier.width(4.dp))
                Caption2(
                    text = stringResource(R.string.sign_up),
                    textColor = DailyTheme.color.Primary20,
                    rippleEnabled = false,
                    onClick = { navigateToSignUp() }
                )
            }
        }
    }
}