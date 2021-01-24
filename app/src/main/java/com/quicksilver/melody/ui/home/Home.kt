package com.quicksilver.melody.ui.home

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksilver.melody.components.MelodyGrid
import com.quicksilver.melody.components.SectionHeader
import com.quicksilver.melody.model.samplePlaylists

@Composable
fun MelodyHome(modifier: Modifier = Modifier) {
    ScrollableColumn(modifier = modifier) {
        SectionHeader(text = "Good evening", modifier = Modifier.padding(8.dp))
        MelodyGrid(modifier = Modifier.padding(horizontal = 4.dp)) {
            samplePlaylists.forEach { playlist ->
                PlaylistEntry(
                    name = playlist.name,
                    imageId = playlist.coverImageId,
                    modifier = Modifier.padding(4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MelodyHomePreview() {
    MelodyHome()
}