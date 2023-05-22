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
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daily.designsystem.theme.Caption1
import com.daily.designsystem.theme.DailyColor
import com.daily.designsystem.theme.DailyTheme
import com.daily.designsystem.theme.Subtitle1
import com.daily.presentation.R

val diary = listOf(
    Pair("title", "date"),
    Pair("title", "date"),
    Pair("title", "date")
)

@Composable
fun ProfileScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DailyTheme.color.Background)
            .systemBarsPadding()
    ) {
        val listState = rememberLazyListState()
        val showShadow by remember {
            derivedStateOf { listState.firstVisibleItemIndex > 0 }
        }

        DiaryHeader(showShadow = showShadow)
        LazyColumn(
            state = listState,
            modifier = modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(top = 16.dp)
        ) {
            items(diary) {
                DiaryItem(title = it.first, date = it.second)
            }
        }
    }
}

@Composable
fun DiaryHeader(
    modifier: Modifier = Modifier,
    showShadow: Boolean
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = if (showShadow) 16.dp else 0.dp,
                spotColor = DailyColor.Shadow
            ),
        color = DailyTheme.color.Background
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "profile",
                modifier = modifier.size(80.dp)
            )
            Spacer(modifier = modifier.width(16.dp))
            Column(modifier = modifier.fillMaxWidth()) {
                Subtitle1(text = "데일리")
                Spacer(modifier = modifier.height(8.dp))
                Caption1(
                    text = "test@gmail.com",
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
    date: String
) {
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
            text = date,
            fontWeight = FontWeight.Medium,
            fontSize = 12.sp,
            color = DailyColor.Neutral40,
            maxLines = 1
        )
    }
}