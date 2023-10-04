package com.daily.presentation.view.auth.signup

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.daily.designsystem.component.button.DailyButton
import com.daily.designsystem.component.DailyTextField
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.Caption1
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcDelete
import com.daily.presentation.R
import com.daily.presentation.viewmodel.util.UiState

@Composable
fun NicknameInput(
    modifier: Modifier = Modifier,
    state: UiState<*>,
    checkDuplicationName: (String) -> Unit,
    onNext: (String) -> Unit
) {
    var nickname by remember { mutableStateOf("") }
    var isNicknameValid by remember { mutableStateOf<Boolean?>(null) }
    var buttonEnabled by remember { mutableStateOf(false) }
    var onClicked by remember { mutableStateOf(false) }

    buttonEnabled = nickname.isNotEmpty()

    if (isNicknameValid == true && onClicked) onNext(nickname)

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
        when (state) {
            is UiState.Success -> isNicknameValid = true
            UiState.Conflict -> {
                isNicknameValid = false
                Caption1(
                    text = stringResource(R.string.nickname_is_already_exist),
                    textColor = DailyTheme.color.Error,
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp)
                )
            }

            UiState.Loading -> {}
            else -> {} // 알 수 없는 오류
        }
        Spacer(
            modifier = modifier.height(
                when (isNicknameValid) {
                    false -> 130.dp
                    else -> 154.dp
                }
            )
        )
        DailyButton(
            text = stringResource(R.string.apply),
            enabled = buttonEnabled,
            modifier = modifier.fillMaxWidth()
        ) {
            onClicked = true
            checkDuplicationName(nickname)
        }
    }
}
