package com.quicksilver.melody.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.quicksilver.melody.components.NoteDetails
import com.quicksilver.melody.components.NoteItems
import com.quicksilver.melody.components.fakeNotes
import com.quicksilver.melody.ui.ScreenName.DETAILS
import com.quicksilver.melody.ui.ScreenName.HOME

@Composable
fun Home() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = HOME.route
    ) {
        composable(route = HOME.route) {
            NoteItems(
                notes = fakeNotes,
                navigateTo = { id -> navController.navigate(route = "${DETAILS.route}/$id") }
            )
        }
        composable(route = "${DETAILS.route}/{id}") { entry ->
            val id = entry.arguments?.getString("id") ?: ""
            NoteDetails(title = id)
        }
    }
}