package com.daily.presentation.view.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.theme.Caption1
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.Subtitle1
import com.daily.presentation.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DailyTheme.color.Background)
            .systemBarsPadding()
    ) {
        val lazyListState = rememberLazyListState()
        val showShadow by remember {
            derivedStateOf { lazyListState.firstVisibleItemIndex > 0 }
        }

        DiaryHeader(
            modifier = Modifier.shadow(
                elevation = if (showShadow) 16.dp else 0.dp,
                spotColor = DailyColor.Shadow
            ),
            name = "데일리_선",
            email = "s31011@gsm.hs.kr",
        )

        LazyColumn(
            state = lazyListState,
            modifier = modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(top = 16.dp),
        ) {
            items(20) {
                val title = "화장실에서 선민재를 봤는데 선민재가 갑자기 넘어졌다."
                val createdDate = LocalDate.now()

                DiaryItem(title = title, createdDate = createdDate)
            }
        }
    }
}

@Composable
fun DiaryHeader(
    modifier: Modifier = Modifier,
    name: String,
    email: String,
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = DailyTheme.color.Background
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top =  48.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "profile",
                modifier = Modifier.size(80.dp)
            )
            Column(modifier = Modifier.fillMaxWidth()) {
                Subtitle1(text = name)
                Spacer(modifier = Modifier.height(8.dp))
                Caption1(
                    text = email,
                    textColor = DailyColor.Neutral30
                )
            }
        }
    }
}

@Composable
fun DiaryItem(
    modifier: Modifier = Modifier,
    title: String,
    createdDate: LocalDate
) {
    val formattedDate = DateTimeFormatter.ofPattern("MM월 dd일").format(createdDate)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DailyTheme.color.White, RoundedCornerShape(16.dp))
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier.weight(1f)
        )
        Spacer(modifier = modifier.width(25.dp))
        Text(
            text = formattedDate,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = DailyColor.Neutral40,
            maxLines = 1
        )
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen()
}
