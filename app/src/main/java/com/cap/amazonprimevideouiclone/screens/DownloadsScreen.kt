package com.cap.amazonprimevideouiclone.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.cap.amazonprimevideouiclone.BottomBarScreens
import com.cap.amazonprimevideouiclone.R
import com.cap.amazonprimevideouiclone.RadialGradient
import com.cap.amazonprimevideouiclone.ToolbarTitle
import com.cap.amazonprimevideouiclone.ui.theme.FF00A8E1
import com.cap.amazonprimevideouiclone.ui.theme.MainThemeColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@Composable
fun DownloadsScreen() {

    val blueColorList = arrayListOf(
        FF00A8E1.copy(alpha = 0.5F),
        FF00A8E1.copy(alpha = 0.3F),
        FF00A8E1.copy(alpha = 0.2F),
        FF00A8E1.copy(alpha = 0.1F),
        FF00A8E1.copy(alpha = 0.05F),
        MainThemeColor
    )

    RadialGradient(colors = blueColorList)

    ToolbarTitle(title = "Downloads")


}
