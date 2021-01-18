package com.quicksilver.melody.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quicksilver.melody.model.samplePlaylist

@Composable
fun MelodyHome(modifier: Modifier = Modifier) {
    // TODO: Implement home screen
    Playlist(playlist = samplePlaylist, modifier = modifier)
}