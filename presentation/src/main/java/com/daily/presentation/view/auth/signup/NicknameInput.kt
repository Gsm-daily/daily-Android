package com.daily.presentation.view.auth.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.daily.designsystem.component.DailyButton
import com.daily.designsystem.component.DailyTextField
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcDelete
import com.daily.presentation.R

@Composable
fun NicknameInput(
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    var nickname by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxWidth()) {
        DailyTextField(
            value = nickname,
            hint = "예시)고양이귀여워",
            onValueChanged = { nickname = it },
            trailingIcon = {
                if (nickname.isNotEmpty()) {
                    IcDelete(
                        contentDescription = "delete",
                        modifier = modifier.dailyClickable(rippleEnable = false) { nickname = "" },
                        tint = DailyTheme.color.Neutral40
                    )
                }
            },
            modifier = modifier.defaultMinSize(minHeight = 24.dp)
        )
        Spacer(modifier = modifier.height(154.dp))
        DailyButton(
            text = stringResource(R.string.apply),
            modifier = modifier.fillMaxWidth()
        ) {
            onNext()
        }
    }
}
