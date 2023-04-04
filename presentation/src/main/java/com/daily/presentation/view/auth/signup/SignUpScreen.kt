package com.daily.presentation.view.auth.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.*
import com.daily.presentation.R

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
) {
    var step by remember { mutableStateOf<SignUpState>(EmainInput) }

    val description = when (step) {
        EmainInput -> R.string.email_authentication
        NicknameInput -> R.string.enter_the_nickname
        PasswordInput -> R.string.enter_the_password
    }

    IcBack(
        contentDescription = "back",
        tint = DailyTheme.color.Black,
        modifier = modifier
            .padding(start = 16.dp, top = 8.dp)
            .dailyClickable(rippleEnable = false) { step = step.previous() }
    )
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        Spacer(modifier = modifier.height(52.dp))
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
            EmainInput -> {
                SignUpEmail { step = step.next() }
            }
            NicknameInput -> {
                SignUpNickname { step = step.next() }
            }
            PasswordInput -> {
                SignUpPassword { step = step.next() }
            }
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
                onClick = { }
            )
        }
    }
}

@Preview
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen()
}