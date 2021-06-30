package com.cap.amazonprimevideouiclone

import android.widget.SearchView
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cap.amazonprimevideouiclone.models.PagerItem
import com.cap.amazonprimevideouiclone.ui.theme.*


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
                    style = TextStyle(color = animateColorAsState(targetValue = if (item.isSelected) Color.White else FF8197A4).value),
                    modifier = Modifier.padding(8.dp),
                    fontFamily = bookerly,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp
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


@Composable
fun RadialGradient(colors: ArrayList<Color>) {
    Box(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    center = Offset(0F, 0F),
                    radius = 800F,
                    colors = colors
                )
            )
    ) {

    }
}

@Composable
fun ToolbarTitle(title: String) {

    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        style = TextStyle(color = Color.White),
        fontFamily = bookerly,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        fontSize = 16.sp
    )
}


@Composable
fun SearchView(modifier: Modifier = Modifier) {

    var text by remember {
        mutableStateOf("")
    }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = text,
        onValueChange = { text = it },
        label = {
            Text(
                text = "Search by actor, title....",
                style = TextStyle(color = B3F3F4F6)
            )
        },
        shape = RoundedCornerShape(4.dp),
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_mic_24),
                contentDescription = null,
                tint = B3F3F4F6
            )
        },
        leadingIcon = {
            Icon(Icons.Default.Search, contentDescription = null, tint = B3F3F4F6)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MainThemeColor.copy(alpha = 0.9F),
            textColor = FF8197A4
        )

    )

}