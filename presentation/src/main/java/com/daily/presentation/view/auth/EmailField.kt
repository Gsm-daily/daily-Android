package com.daily.presentation.view.auth

import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.daily.designsystem.component.DailyTextField
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcDelete
import com.daily.designsystem.theme.IcMail

@Composable
fun EmailField(
    modifier: Modifier = Modifier,
    leadingIconEnabled: Boolean = true,
    trailingIconEnabled: Boolean = true,
    onValueChanged: (String) -> Unit
) {
    var email by remember { mutableStateOf("") }

    DailyTextField(
        modifier = modifier,
        value = email,
        hint = stringResource(com.daily.presentation.R.string.enter_the_email),
        leadingIcon = {
            if (leadingIconEnabled) {
                IcMail(
                    contentDescription = "email",
                    tint = DailyTheme.color.Black
                )
            }
        },
        trailingIcon = {
            if (email.isNotEmpty() && trailingIconEnabled) {
                IcDelete(
                    contentDescription = "delete",
                    modifier = Modifier.dailyClickable(rippleEnable = false) { email = "" },
                    tint = DailyTheme.color.Neutral40
                )
            }
        },
        onValueChanged = {
            email = it
            onValueChanged(it)
        }
    )
}