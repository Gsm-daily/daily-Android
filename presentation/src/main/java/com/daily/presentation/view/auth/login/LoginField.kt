package com.daily.presentation.view.auth.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import com.daily.designsystem.component.DailyTextField
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.component.DailyButton
import com.daily.designsystem.theme.*

@Composable
fun LoginField(
    modifier: Modifier = Modifier,
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isEmailValid by remember { mutableStateOf(true) }
    var isPasswordBlank by remember { mutableStateOf(false) }
    var isPasswordShowed by remember { mutableStateOf(false) }

    DailyTextField(
        value = email,
        hint = stringResource(com.daily.presentation.R.string.enter_the_email),
        leadingIcon = {
            IcMail(
                contentDescription = "email",
                tint = DailyTheme.color.Black
            )
        },
        trailingIcon = {
            if (email.isNotEmpty()) {
                IcDelete(
                    contentDescription = "delete",
                    modifier = modifier.dailyClickable(rippleEnable = false) { email = "" },
                    tint = DailyTheme.color.Neutral40
                )
            }
        },
        onValueChanged = {
            email = it
            isEmailValid = if (email.isEmpty()) true else EMAIL_ADDRESS.matcher(email).matches()
        }
    )

    if (!isEmailValid) {
        Caption1(
            text = stringResource(com.daily.presentation.R.string.email_format_not_valid),
            textColor = DailyTheme.color.Error,
            modifier = modifier.padding(horizontal = 8.dp, vertical = 8.dp)
        )
    }
    Spacer(modifier = modifier.height(12.dp))

    DailyTextField(
        value = password,
        hint = stringResource(com.daily.presentation.R.string.enter_the_password),
        visualTransformation = if (isPasswordShowed) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            IcLock(
                contentDescription = "password",
                tint = DailyTheme.color.Black
            )
        },
        trailingIcon = {
            if (password.isNotEmpty()) {
                when (isPasswordShowed) {
                    true -> {
                        IcEyeClose(
                            contentDescription = "hidePassword",
                            tint = DailyTheme.color.Neutral40,
                            modifier = modifier.dailyClickable(rippleEnable = false) { isPasswordShowed = !isPasswordShowed }
                        )
                    }
                    false -> {
                        IcEyeOpen(
                            contentDescription = "showPassword",
                            tint = DailyTheme.color.Neutral40,
                            modifier = modifier.dailyClickable(rippleEnable = false) { isPasswordShowed = !isPasswordShowed }
                        )
                    }
                }
            }
        },
        onValueChanged = { password = it }
    )
    Spacer(modifier = modifier.height(12.dp))
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        horizontalArrangement = Arrangement.End
    ) {
        if (isPasswordBlank) {
            Caption1(
                text = stringResource(com.daily.presentation.R.string.password_is_blank),
                textColor = DailyTheme.color.Error
            )
            Spacer(modifier = modifier.weight(1f))
        }
        Caption1(
            text = stringResource(com.daily.presentation.R.string.forgot_password),
            textColor = DailyTheme.color.Neutral40,
            rippleEnabled = false,
            onClick = { }
        )
    }
    Spacer(modifier = modifier.height(if (isPasswordBlank) 56.dp else 26.dp))
    DailyButton(
        text = stringResource(com.daily.presentation.R.string.login),
        modifier = modifier.fillMaxWidth(),
        onClick = { isPasswordBlank = password.isEmpty() }
    )
}