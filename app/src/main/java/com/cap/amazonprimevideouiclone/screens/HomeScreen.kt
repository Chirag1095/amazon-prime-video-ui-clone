package com.cap.amazonprimevideouiclone.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.cap.amazonprimevideouiclone.MainActivityViewModel
import com.cap.amazonprimevideouiclone.PagerTitle
import com.cap.amazonprimevideouiclone.models.PagerItem


@Composable
fun HomeScreen(modifier: Modifier = Modifier, mainActivityViewModel: MainActivityViewModel) {
    PagerTitle(mainActivityViewModel = mainActivityViewModel)
}


