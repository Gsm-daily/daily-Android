package com.daily.presentation.view.signin

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daily.designsystem.component.kakao.KakaoButton
import com.daily.designsystem.theme.Body1
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.Subtitle0
import com.daily.presentation.R

@Composable
fun SignInScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.paint(
            painter = painterResource(id = R.drawable.bg_signin),
            contentScale = ContentScale.Crop
        ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = DailyColor.FeatureColor.BottomSheetColor,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .border(
                    color = DailyColor.White,
                    width = 2.dp,
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
                )
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SignInHeader(modifier = Modifier.padding(vertical = 40.dp))
            KakaoButton(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(vertical = 16.dp)
            ) {
                /* TODO: 카카오 로그인 로직 */
            }
            Spacer(modifier = Modifier.height(66.dp))
        }
    }
}

@Composable
fun SignInHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Subtitle0(
            text = "매일매일 성장하는 일기장",
            textColor = DailyColor.Black
        )
        Body1(
            text = "하루하루 일기를 작성하면 나와 함께 성장하는\n다양한 테마들을 꾸며보세요!",
            textColor = DailyColor.Neutral50,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    SignInScreen()
}
