package com.quicksilver.melody.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.melody.model.samplePlaylist
import com.quicksilver.melody.ui.home.Playlist
import com.quicksilver.melody.ui.theme.MelodyTheme

@Composable
fun MelodyApp() {
    MelodyThemedContent {
        Playlist(playlist = samplePlaylist)
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