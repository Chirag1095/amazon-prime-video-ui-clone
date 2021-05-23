package com.cap.amazonprimevideouiclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.cap.amazonprimevideouiclone.ui.theme.AmazonPrimeVideoUICloneTheme
import com.cap.amazonprimevideouiclone.ui.theme.MainThemeColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {

    private val mainActivityViewModel by viewModels<MainActivityViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            App {
                MainScreen(mainActivityViewModel)
            }
        }
    }
}


@Composable
fun App(content: @Composable () -> Unit) {

    //Set status bar color to black
    /*rememberSystemUiController().setSystemBarsColor(
        color = Color.Black
    )*/

    AmazonPrimeVideoUICloneTheme {
        content()
    }
}

@Composable
fun MainScreen(mainActivityViewModel: MainActivityViewModel) {
    Scaffold(
        backgroundColor = MainThemeColor,
        topBar = {
            TopAppBar(backgroundColor = MainThemeColor) {
                TopAppBar()
            }
        },
        bottomBar = {
            BottomAppBar(backgroundColor = Color.Black) {

                BottomNavigation(backgroundColor = Color.Black) {

                    BottomNavigationItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = { BottomBarItem(R.drawable.ic_outline_home_24) },
                        label = { Text(text = "Home", style = TextStyle(color = Color.White)) }
                    )

                    BottomNavigationItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = { BottomBarItem(R.drawable.ic_baseline_search_24) },
                        label = { Text(text = "Search", style = TextStyle(color = Color.White)) }
                    )

                    BottomNavigationItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = { BottomBarItem(R.drawable.ic_baseline_arrow_circle_down_24) },
                        label = { Text(text = "Downloads", style = TextStyle(color = Color.White)) }
                    )

                    BottomNavigationItem(
                        selected = true,
                        onClick = { /*TODO*/ },
                        icon = { BottomBarItem(R.drawable.ic_baseline_perm_identity_24) },
                        label = { Text(text = "My Stuff", style = TextStyle(color = Color.White)) }
                    )
                }
            }
        }
    ) {

        Column {
            PagerTitle(mainActivityViewModel = mainActivityViewModel)
        }

    }
}

@Composable
fun BottomBarItem(imageId: Int) {

    Image(
        painter = painterResource(imageId),
        contentDescription = "",
    )

}

@Composable
fun TopAppBar() {
    Row(
        Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_prime_now),
            contentDescription = "",
            modifier = Modifier
                .width(80.dp)
                .height(130.dp)
        )
    }
}

