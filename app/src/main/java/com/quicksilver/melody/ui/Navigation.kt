package com.quicksilver.melody.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.quicksilver.melody.ui.Destination.*
import com.quicksilver.melody.ui.ScreenName.*

enum class ScreenName(val route: String) {
    HOME("home"),
    SEARCH("search"),
    LIBRARY("library")
}

sealed class Destination(val name: ScreenName, val label: String, val icon: ImageVector) {

    val route: String = name.route

    object Home : Destination(name = HOME, label = "Home", icon = Icons.Outlined.Home)
    object Search : Destination(name = SEARCH, label = "Search", icon = Icons.Outlined.Search)
    object Library : Destination(name = LIBRARY, label = "Library", icon = Icons.Outlined.LibraryMusic)
}

@Composable
fun NavigationGraph(startDestination: Destination = Home) {
    val navController = rememberNavController()
    val navActions = remember(navController) { NavigationActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination.route
    ) {
        composable(Home.route) { navActions.goToHome }
        composable(Search.route) { navActions.goToSearch }
        composable(Library.route) { navActions.goToLibrary }
    }
}

class NavigationActions(navController: NavController) {
    val goToHome: () -> Unit = {
        navController.navigate(route = Home.route)
    }
    val goToSearch: () -> Unit = {
        navController.navigate(route = Search.route)
    }
    val goToLibrary: () -> Unit = {
        navController.navigate(route = Library.route)
    }
}