package com.cap.amazonprimevideouiclone.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import com.cap.amazonprimevideouiclone.BottomBarScreens
import com.cap.amazonprimevideouiclone.R

@Composable
fun MyStuffScreen() {
    Text(text = stringResource(id = R.string.my_stuff_screen),style = TextStyle(color = Color.White))
}