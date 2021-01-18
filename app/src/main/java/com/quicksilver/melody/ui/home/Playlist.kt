package com.quicksilver.melody.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksilver.melody.components.HollowButton
import com.quicksilver.melody.components.ShuffleButton
import com.quicksilver.melody.components.SongRow
import com.quicksilver.melody.components.VerticalSpace
import com.quicksilver.melody.model.Playlist
import com.quicksilver.melody.model.Song
import com.quicksilver.melody.model.samplePlaylist
import com.quicksilver.melody.ui.theme.MelodyTheme
import com.quicksilver.melody.ui.theme.typography
import java.util.*

@Composable
fun Playlist(playlist: Playlist, modifier: Modifier = Modifier) {
    Surface(color = Color.Black, modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)
        ) {
            PlaylistHeader(playlist = playlist)
            SongList(songs = playlist.songs)
        }
    }
}

@Composable
fun PlaylistHeader(playlist: Playlist) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            imageResource(id = playlist.coverImageId),
            contentScale = ContentScale.Crop,
            modifier = Modifier.preferredSize(200.dp)
        )
        VerticalSpace(height = 8.dp)
        Text(
            text = playlist.name,
            style = typography.h6.copy(fontSize = 22.sp, color = Color.White),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "BY ${playlist.creator.toUpperCase(Locale.getDefault())}",
            style = typography.h5.copy(fontSize = 8.sp, color = Color.White)
        )
        VerticalSpace(height = 12.dp)
        ShuffleButton()
        VerticalSpace(height = 12.dp)
        HollowButton()
    }
}

@Composable
fun SongList(songs: List<Song>) {
    LazyColumn(
        contentPadding = PaddingValues(all = 8.dp),
        verticalArrangement = Arrangement.spacedBy(space = 8.dp)
    ) {
        items(songs) { song ->
            val (title, artist, album) = song
            SongRow(
                albumCoverId = album.coverId ?: 0,
                songTitle = title,
                artistName = artist
            )
        }
    }
}

@Preview
@Composable
fun PlaylistPreview() {
    MelodyTheme {
        Playlist(playlist = samplePlaylist, modifier = Modifier.fillMaxSize())
    }
}

@Preview
@Composable
fun PlaylistHeaderPreview() {
    MelodyTheme {
        PlaylistHeader(playlist = samplePlaylist)
    }
}