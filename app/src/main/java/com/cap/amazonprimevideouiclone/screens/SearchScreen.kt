package com.cap.amazonprimevideouiclone.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.sourceInformationMarkerEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.cap.amazonprimevideouiclone.BottomBarScreens
import com.cap.amazonprimevideouiclone.R
import com.cap.amazonprimevideouiclone.RadialGradient
import com.cap.amazonprimevideouiclone.SearchView
import com.cap.amazonprimevideouiclone.ui.theme.FF00A8E1
import com.cap.amazonprimevideouiclone.ui.theme.FF2E1B44
import com.cap.amazonprimevideouiclone.ui.theme.MainThemeColor

@Composable
fun SearchScreen() {

    val blueColorList = arrayListOf(
        FF00A8E1.copy(alpha = 0.5F),
        FF00A8E1.copy(alpha = 0.3F),
        FF00A8E1.copy(alpha = 0.2F),
        FF00A8E1.copy(alpha = 0.1F),
        FF00A8E1.copy(alpha = 0.05F),
        MainThemeColor
    )

    val scrollState = rememberScrollState()

    RadialGradient(colors = blueColorList)

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        SearchView()
    }


}