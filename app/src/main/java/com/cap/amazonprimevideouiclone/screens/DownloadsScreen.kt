package com.cap.amazonprimevideouiclone.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.cap.amazonprimevideouiclone.BottomBarScreens
import com.cap.amazonprimevideouiclone.R

@Composable
fun DownloadsScreen() {
    Text(text = stringResource(id = R.string.downloads_screen),style = TextStyle(color = Color.White))
}