package com.quicksilver.melody.ui

import com.quicksilver.melody.ui.ScreenName.DETAILS
import com.quicksilver.melody.ui.ScreenName.HOME

enum class ScreenName(val route: String) {
    HOME("home"),
    DETAILS("details")
}

sealed class Screen(val name: ScreenName) {
    object Home : Screen(HOME)
    data class Details(val id: String) : Screen(DETAILS)
}