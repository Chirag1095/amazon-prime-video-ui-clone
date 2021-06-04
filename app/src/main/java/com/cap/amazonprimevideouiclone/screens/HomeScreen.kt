package com.cap.amazonprimevideouiclone.screens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.cap.amazonprimevideouiclone.MainActivityViewModel
import com.cap.amazonprimevideouiclone.PagerTitle
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.cap.amazonprimevideouiclone.R
import com.cap.amazonprimevideouiclone.ui.theme.bookerly


@ExperimentalPagerApi
@Composable
fun HomeScreen(modifier: Modifier = Modifier, mainActivityViewModel: MainActivityViewModel) {

    val posterList = arrayListOf(
        R.drawable.blood_shot,
        R.drawable.blood_shot,
        R.drawable.blood_shot,
        R.drawable.blood_shot
    )

    Column {

        PagerTitle(mainActivityViewModel = mainActivityViewModel)

        PosterViewPager()

    }

}

@ExperimentalPagerApi
@Composable
fun PosterViewPager() {

    val pager = rememberPagerState(pageCount = 5)

    HorizontalPager(state = pager) {
        Image(
            painter = painterResource(id = R.drawable.blood_shot),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.30F)
                .aspectRatio(ratio = 1f)
        )
    }
}
