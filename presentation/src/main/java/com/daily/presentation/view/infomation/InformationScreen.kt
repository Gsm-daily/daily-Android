package com.daily.presentation.view.infomation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.component.button.DailyButton
import com.daily.designsystem.component.textfield.DailyTextField
import com.daily.designsystem.component.theme.DailyThemeRadio
import com.daily.designsystem.component.theme.Theme
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.Body3
import com.daily.designsystem.theme.Caption1
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.IcBack

@Composable
fun InformationScreen(modifier: Modifier = Modifier) {
    var selectedTheme by remember { mutableStateOf("") }
    var nickname by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DailyColor.White)
            .systemBarsPadding()
            .padding(horizontal = 20.dp)
    ) {
        InformationTopBar()
        Spacer(modifier = Modifier.height(25.dp))
        Body3(text = "닉네임")
        Spacer(modifier = Modifier.height(8.dp))
        DailyTextField(
            value = nickname,
            hint = "예시)고양이귀여워",
            onValueChange = { nickname = it }
        )
        Spacer(modifier = Modifier.height(35.dp))
        Body3(text = "테마 선택")
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.dailyClickable(rippleEnable = false) {
                    selectedTheme = "GRASSLAND"
                },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                DailyThemeRadio(
                    selected = selectedTheme == "GRASSLAND",
                    theme = Theme.GRASSLAND
                )
                Spacer(modifier = Modifier.height(8.dp))
                Caption1(text = "초원")
            }
            Spacer(modifier = Modifier.width(35.dp))
            Column(
                modifier = Modifier.dailyClickable(rippleEnable = false) {
                    selectedTheme = "OCEAN"
                },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                DailyThemeRadio(
                    selected = selectedTheme == "OCEAN",
                    theme = Theme.OCEAN
                )
                Spacer(modifier = Modifier.height(8.dp))
                Caption1(text = "바다")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        DailyButton(
            modifier = Modifier.fillMaxWidth(),
            text = "완료"
        ) {
            /* TODO: 정보 입력 로직 */
        }
        Spacer(modifier = Modifier.height(58.dp))
    }
}

@Composable
fun InformationTopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        IcBack(
            modifier = Modifier.dailyClickable { /* TODO: 뒤로가기 처리 */ },
            contentDescription = "back"
        )
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = "정보 입력",
            fontSize = 17.sp,
            fontWeight = FontWeight.Normal
        )
    }
}

@Preview
@Composable
fun InformationScreenPreview() {
    InformationScreen(modifier = Modifier.background(DailyColor.White))
}
