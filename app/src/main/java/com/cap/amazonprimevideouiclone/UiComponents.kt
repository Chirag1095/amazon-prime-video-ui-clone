package com.cap.amazonprimevideouiclone

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.cap.amazonprimevideouiclone.models.PagerItem


@Composable
fun PagerTitle(modifier: Modifier = Modifier, mainActivityViewModel: MainActivityViewModel) {

    val list: ArrayList<PagerItem> by
    mainActivityViewModel.pagerItems.observeAsState(arrayListOf())

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
    ) {

        for (item in list) {

            Column(
                modifier = Modifier.clickable { mainActivityViewModel.onPagerItemSelected(item) },
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = item.pagerTitle,
                    style = TextStyle(color = animateColorAsState(targetValue = if (item.isSelected) Color.White else Color.Gray).value),
                    modifier = Modifier.padding(8.dp)
                )

                Divider(
                    modifier = Modifier
                        .background(
                            color = animateColorAsState(
                                targetValue = if (item.isSelected) Color.White else Color.Transparent
                            ).value
                        )
                        .height(2.dp)
                        .width(80.dp)
                )
            }
        }
    }
}
