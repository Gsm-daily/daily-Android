package com.daily.presentation.view.auth.select_theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.daily.designsystem.theme.DailyTheme
import com.daily.presentation.R
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp

private const val PAGE_COUNT = 2

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ThemeField(
    modifier: Modifier = Modifier,
    pagerState: PagerState
) {
    Column {
        HorizontalPager(
            pageCount = PAGE_COUNT,
            state = pagerState,
            pageSize = PageSize.Fixed(247.dp),
            contentPadding = PaddingValues(horizontal = 64.dp),
            pageSpacing = 32.dp
        ) { page ->
            val (image, description) = when (page) {
                0 -> Pair(R.drawable.bg_grassland7, "grassland")
                1 -> Pair(R.drawable.bg_ocean7, "ocean")
                else -> Pair(null, null)
            }

            image?.let {
                val pageOffset = (
                        (pagerState.currentPage - page) + pagerState
                            .currentPageOffsetFraction
                        ).absoluteValue

                Image(
                    painter = painterResource(id = it),
                    contentDescription = description,
                    modifier = modifier
                        .size(247.dp, 534.dp)
                        .clip(RoundedCornerShape(24.dp)),
                    colorFilter = ColorFilter.tint(
                        Color(
                            0f, 0f, 0f, lerp(
                                start = 0f,
                                stop = 0.3f,
                                fraction = pageOffset.coerceIn(0f, 1f)
                            )
                        ),
                        BlendMode.Darken
                    )
                )
            }
        }
        Spacer(modifier = modifier.height(24.dp))
        Row(
            modifier = modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(PAGE_COUNT) {
                val color = if (pagerState.currentPage == it) DailyTheme.color.Neutral50 else DailyTheme.color.Neutral20
                Box(
                    modifier = modifier
                        .padding(horizontal = 4.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(6.dp)
                )
            }
        }
    }
}