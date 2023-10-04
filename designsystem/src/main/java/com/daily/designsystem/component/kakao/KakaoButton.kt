package com.daily.designsystem.component.kakao

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daily.designsystem.R
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.DailyTypography

@Composable
fun KakaoButton(
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(12.dp),
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        shape = shape,
        colors = ButtonDefaults.buttonColors(containerColor = DailyColor.FeatureColor.KakaoContainerColor),
        contentPadding = contentPadding,
        onClick = onClick
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            tint = DailyColor.Black,
            painter = painterResource(id = R.drawable.ic_kakao_symbol),
            contentDescription = "kakao symbol"
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "카카오 로그인",
            style = DailyTypography.body1,
            color = DailyColor.FeatureColor.KakaoLabelColor
        )
    }
}

@Preview
@Composable
fun KakaoButtonPreview() {
    KakaoButton(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 16.dp),
        onClick = {}
    )
}
