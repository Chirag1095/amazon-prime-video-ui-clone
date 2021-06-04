package com.cap.amazonprimevideouiclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.cap.amazonprimevideouiclone.screens.DownloadsScreen
import com.cap.amazonprimevideouiclone.screens.MyStuffScreen
import com.cap.amazonprimevideouiclone.screens.HomeScreen
import com.cap.amazonprimevideouiclone.screens.SearchScreen
import com.cap.amazonprimevideouiclone.ui.theme.*
import com.google.accompanist.pager.ExperimentalPagerApi


@ExperimentalPagerApi
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

@ExperimentalPagerApi
@Composable
fun MainScreen(mainActivityViewModel: MainActivityViewModel) {

    val navController = rememberNavController()

    val screenList = listOf(
        BottomBarScreens.HomeScreen,
        BottomBarScreens.SearchScreen,
        BottomBarScreens.DownloadsScreen,
        BottomBarScreens.MyStuffScreen
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        backgroundColor = MainThemeColor,
        topBar = {
            if (currentRoute == BottomBarScreens.HomeScreen.routeName) {
                TopAppBar(backgroundColor = MainThemeColor) {
                    if (currentRoute == BottomBarScreens.HomeScreen.routeName) {
                        ImageTopAppBar()
                    }
                }
            }
        },
        bottomBar = {
            BottomBarItem(
                navController = navController,
                items = screenList,
                currentRoute = currentRoute
            )
        }
    ) {

        NavHost(navController, startDestination = BottomBarScreens.HomeScreen.routeName) {

            composable(BottomBarScreens.HomeScreen.routeName) {
                HomeScreen(mainActivityViewModel = mainActivityViewModel)
            }

            composable(BottomBarScreens.SearchScreen.routeName) {
                SearchScreen()
            }

            composable(BottomBarScreens.DownloadsScreen.routeName) {
                DownloadsScreen()
            }

            composable(BottomBarScreens.MyStuffScreen.routeName) {
                MyStuffScreen()
            }
        }

    }
}

@Composable
fun BottomBarItem(
    navController: NavController,
    items: List<BottomBarScreens>,
    currentRoute: String?
) {

    BottomNavigation(
        backgroundColor = Color.Black
    ) {

        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = it.bottomBarIcon),
                        contentDescription = null,
                        tint = if (currentRoute == it.routeName) FF00A8E1 else B3F3F4F6
                    )
                },
                label = {
                    Text(
                        text = stringResource(it.bottomBarTitle),
                        style = TextStyle(color = if (currentRoute == it.routeName) FF00A8E1 else B3F3F4F6),
                        fontSize = 10.sp,
                        fontFamily = bookerly,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
                    )
                },
                selected = currentRoute == it.routeName,
                alwaysShowLabel = true,
                onClick = {
                    if (currentRoute != it.routeName) {
                        navController.navigate(it.routeName)
                    }
                }
            )
        }
    }
}

@Composable
fun ImageTopAppBar() {
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