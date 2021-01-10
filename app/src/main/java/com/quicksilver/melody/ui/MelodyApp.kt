package com.quicksilver.melody.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.melody.ui.home.Home

@Composable
fun MelodyApp() {
    MelodyThemedContent {
        Home()
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