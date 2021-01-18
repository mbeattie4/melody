package com.quicksilver.melody.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.melody.ui.Destination.*
import com.quicksilver.melody.ui.ScreenName.*
import com.quicksilver.melody.ui.home.MelodyHome
import com.quicksilver.melody.ui.home.MelodyLibrary
import com.quicksilver.melody.ui.home.MelodySearch
import com.quicksilver.melody.ui.theme.MelodyTheme

@Composable
fun MelodyApp() {
    MelodyThemedContent {
        val (selectedTab, setSelectedTab) = remember { mutableStateOf(HOME) }
        Scaffold(
            backgroundColor = Color.Black,
            bottomBar = {
                MelodyBottomBar(
                    tabs = listOf(Home, Search, Library),
                    selectedTabName = selectedTab,
                    selectTab = setSelectedTab
                )
            }
        ) { innerPadding ->
            MelodyBodyContent(
                selectedTab = selectedTab,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun MelodyBottomBar(
    tabs: List<Destination> = listOf(Home, Search, Library),
    selectedTabName: ScreenName = HOME,
    selectTab: (ScreenName) -> Unit = {}
) {
    BottomNavigation(backgroundColor = Color.Black) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = { Icon(imageVector = tab.icon, tint = Color.White) },
                label = { Text(text = tab.label, color = Color.White) },
                selected = (tab.name == selectedTabName),
                onClick = { selectTab(tab.name) }
            )
        }
    }
}

@Composable
fun MelodyBodyContent(selectedTab: ScreenName, modifier: Modifier = Modifier) {
    when (selectedTab) {
        HOME -> MelodyHome(modifier = modifier)
        SEARCH -> MelodySearch(modifier = modifier)
        LIBRARY -> MelodyLibrary(modifier = modifier)
    }
}

@Composable
fun MelodyThemedContent(content: @Composable () -> Unit) {
    MelodyTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview
@Composable
fun MelodyAppPreview() {
    MelodyApp()
}

@Preview
@Composable
fun MelodyBottomBarPreview() {
    MelodyTheme {
        MelodyBottomBar()
    }
}