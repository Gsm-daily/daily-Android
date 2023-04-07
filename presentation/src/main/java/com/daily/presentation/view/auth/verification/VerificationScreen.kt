package com.daily.presentation.view.auth.verification

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.*
import com.daily.presentation.R

private const val CODE_LENGTH = 4

@Composable
fun VerificationScreen(
    modifier: Modifier = Modifier,
    email: String?,
    navigateToPrevious: () -> Unit,
    navigateToNext: (String) -> Unit
) {
    var code by remember { mutableStateOf("") }

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
        Spacer(modifier = modifier.height(76.dp))
        H0(
            text = "5 : 00",
            textColor = DailyTheme.color.Black
        )
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
                if (it.length <= CODE_LENGTH) {
                    code = it
                    if (it.length == CODE_LENGTH) navigateToNext(checkNotNull(email))
                }
            }
        )
        Spacer(modifier = modifier.height(16.dp))
        Caption2(
            text = stringResource(R.string.resend),
            textColor = DailyTheme.color.Primary20,
            rippleEnabled = false,
            onClick = { }
        )
    }
}