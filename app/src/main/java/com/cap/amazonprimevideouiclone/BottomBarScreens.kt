package com.cap.amazonprimevideouiclone

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class BottomBarScreens(
    val routeName: String,
    @StringRes val bottomBarTitle: Int,
    @DrawableRes val bottomBarIcon: Int
) {

    object HomeScreen :
        BottomBarScreens(
            routeName = "home",
            bottomBarTitle = R.string.home_screen,
            bottomBarIcon = R.drawable.ic_outline_home_24
        )

    object SearchScreen :
        BottomBarScreens(
            routeName = "search",
            bottomBarTitle = R.string.search_screen,
            bottomBarIcon = R.drawable.ic_baseline_search_24
        )

    object DownloadsScreen : BottomBarScreens(
        routeName = "downloads",
        bottomBarTitle = R.string.downloads_screen,
        bottomBarIcon = R.drawable.ic_baseline_arrow_circle_down_24
    )

    object MyStuffScreen : BottomBarScreens(
        routeName = "my_stuff",
        bottomBarTitle = R.string.my_stuff_screen,
        bottomBarIcon = R.drawable.ic_baseline_perm_identity_24
    )
}
