package com.daily.presentation.view.diary

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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.IcBack
import com.daily.designsystem.theme.IcTrashCan
import com.daily.designsystem.theme.IcWrite
import com.daily.presentation.R

@Composable
fun DiaryScreen(
    modifier: Modifier = Modifier,
    date: String?
) {
    var content by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 12.dp, end = 20.dp)
            .paint(
                painter = painterResource(id = R.drawable.bg_diary),
                contentScale = ContentScale.Crop,
            )
            .systemBarsPadding()
    ) {
        Spacer(modifier = modifier.height(16.dp))
//        DiaryTopBar(isEditable = isEditable) TODO: 일기 조회 기능 추가한 후 수정
        Spacer(modifier = modifier.height(16.dp))
        BasicTextField(
            value = content,
            onValueChange = { content = it },
            modifier = modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 4.dp),
            textStyle = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp
            ),
//            readOnly = !isEditable,  TODO: 일기 조회 기능 추가한 후 수정
            decorationBox = { innerTextField ->
                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
//                    TODO: 일기 조회 기능 추가한 후 수정
//                    if (content.isEmpty() && isEditable) {
//                        Body2(
//                            text = "적어!",
//                            textColor = DailyTheme.color.Hint,
//                        )
//                    }
                    innerTextField()
                }
            }
        )
    }
}

@Composable
fun DiaryTopBar(
    modifier: Modifier = Modifier,
    isEditable: Boolean
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IcBack(
            contentDescription = "back",
            modifier = modifier.dailyClickable(rippleEnable = false) { }
        )
        Spacer(modifier = modifier.width(10.dp))
        Text(
            text = "2005년 02월 10일",
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        Spacer(modifier = modifier.weight(1f))
        if (isEditable) {
            Text(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                text = "저장"
            )
        } else {
            IcWrite(
                contentDescription = "write_diary",
                modifier = modifier.dailyClickable(rippleEnable = false) { }
            )
            Spacer(modifier = modifier.width(16.dp))
            IcTrashCan(
                contentDescription = "delete_diary",
                modifier = modifier.dailyClickable(rippleEnable = false) { }
            )
        }
    }
}
