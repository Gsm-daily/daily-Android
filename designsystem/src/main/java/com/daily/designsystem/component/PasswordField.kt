package com.daily.designsystem.component

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcEyeClose
import com.daily.designsystem.theme.IcEyeOpen
import com.daily.designsystem.theme.IcLock

@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    hint: String = "",
    leadingIconEnabled: Boolean = true,
    trailingIconEnabled: Boolean = true,
    onValueChanged: (String) -> Unit
) {
    var password by remember { mutableStateOf("") }
    var isPasswordShowed by remember { mutableStateOf(false) }

    DailyTextField(
        modifier = modifier,
        value = password,
        hint = hint,
        visualTransformation = if (isPasswordShowed) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        leadingIcon = {
            if (leadingIconEnabled) {
                IcLock(
                    contentDescription = "password",
                    tint = DailyTheme.color.Black
                )
            }
        },
        trailingIcon = {
            if (password.isNotEmpty() && trailingIconEnabled) {
                when (isPasswordShowed) {
                    true -> {
                        IcEyeClose(
                            contentDescription = "hidePassword",
                            tint = DailyTheme.color.Neutral40,
                            modifier = Modifier.dailyClickable(rippleEnable = false) {
                                isPasswordShowed = !isPasswordShowed
                            }
                        )
                    }
                    false -> {
                        IcEyeOpen(
                            contentDescription = "showPassword",
                            tint = DailyTheme.color.Neutral40,
                            modifier = Modifier.dailyClickable(rippleEnable = false) {
                                isPasswordShowed = !isPasswordShowed
                            }
                        )
                    }
                }
            }
        },
        onValueChanged = {
            password = it
            onValueChanged(it)
        }
    )
}