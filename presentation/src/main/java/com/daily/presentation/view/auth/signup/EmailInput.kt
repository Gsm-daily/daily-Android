package com.daily.presentation.view.auth.signup

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
import com.daily.presentation.view.auth.EmailField

@Composable
fun EmailInput(
    modifier: Modifier = Modifier,
    onNext: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(true) }

    Column(modifier = modifier.fillMaxWidth()) {
        EmailField(
            modifier = modifier.defaultMinSize(minHeight = 24.dp),
            leadingIconEnabled = false
        ) {
            email = it
            isEmailValid = PatternsCompat.EMAIL_ADDRESS.matcher(it).matches()
        }
        if (!isEmailValid) {
            Caption1(
                text = stringResource(R.string.email_format_not_valid),
                textColor = DailyTheme.color.Error,
                modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
            )
        }
        Spacer(modifier = modifier.height(if (isEmailValid) 154.dp else 116.dp))
        DailyButton(
            text = stringResource(R.string.get_verification_code),
            modifier = modifier.fillMaxWidth()
        ) {
            isEmailValid = if (email.isEmpty()) false else PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
            if (isEmailValid) onNext(email)
        }
    }
}