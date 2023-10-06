package com.daily.presentation.view.diary

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.modifier.dailyClickable
import com.daily.designsystem.theme.Body2
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.IcBack
import com.daily.designsystem.theme.IcTrashCan
import com.daily.designsystem.theme.IcWrite
import com.daily.designsystem.theme.notosanskr
import com.daily.presentation.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DiaryScreen(
    modifier: Modifier = Modifier,
    date: String?
) {
    // TODO: 해당 날짜의 일기를 조회
    var content by remember { mutableStateOf("") }
    var isEditable by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.bg_diary),
                contentScale = ContentScale.Crop,
            )
            .padding(horizontal = 24.dp)
            .systemBarsPadding()
    ) {
        DiaryTopBar(
            date = LocalDate.parse(date),
            isEditable = isEditable,
            onBackClick = { /* TODO: 뒤로가기 로직 */ },
            onSaveClick = {
                /* TODO: 일기 저장 로직 추가 */
                isEditable = false
            },
            onEditClick = { isEditable = true },
            onDeleteClick = { /* TODO: 일기 삭제 로직 */ }
        )
        BasicTextField(
            modifier = modifier.fillMaxWidth(),
            value = content,
            onValueChange = { content = it },
            textStyle = TextStyle(
                fontFamily = notosanskr,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            ),
            readOnly = !isEditable,
            decorationBox = { innerTextField ->
                Box(
                    modifier = modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (content.isEmpty() && isEditable) {
                        Body2(
                            text = "적어!",
                            textColor = DailyTheme.color.Hint
                        )
                    }
                    innerTextField()
                }
            }
        )
    }
}

@Composable
fun DiaryTopBar(
    modifier: Modifier = Modifier,
    date: LocalDate,
    isEditable: Boolean,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit
) {
    val formattedDate = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일").format(date)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        IcBack(
            modifier = modifier
                .dailyClickable(
                    rippleEnable = false,
                    onClick = onBackClick
                )
                .padding(top = 2.dp),
            contentDescription = "back",
        )
        Spacer(modifier = modifier.width(10.dp))
        Text(
            text = formattedDate,
            style = TextStyle(
                fontFamily = notosanskr,
                fontWeight = FontWeight.Medium,
                fontSize = 18.sp,
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            )
        )
        Spacer(modifier = modifier.weight(1f))
        if (isEditable) {
            Text(
                modifier = Modifier.dailyClickable(
                    rippleEnable = false,
                    onClick = onSaveClick
                ),
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                text = "저장"
            )
        } else {
            IcWrite(
                modifier = modifier.dailyClickable(
                    rippleEnable = false,
                    onClick = onEditClick
                ),
                contentDescription = "write_diary"
            )
            Spacer(modifier = modifier.width(16.dp))
            IcTrashCan(
                modifier = modifier.dailyClickable(
                    rippleEnable = false,
                    onClick = onDeleteClick
                ),
                contentDescription = "delete_diary"
            )
        }
    }
}

@Preview
@Composable
fun DiaryScreenPreview() {
    DiaryScreen(date = LocalDate.now().toString())
}
