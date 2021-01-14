package com.quicksilver.melody.model

import androidx.annotation.DrawableRes
import com.quicksilver.melody.R

data class Song(
    val title: String,
    val artistName: String,
    val album: Album
)

data class Album(
    @DrawableRes val coverId: Int? = null,
    val coverUrl: String? = null
)

val sampleSongs: List<Song> = listOf(
    Song(
        title = "Crash & Burn",
        artistName = "G-Easy, Kehlani",
        album = Album(coverId = R.drawable.g_easy)
    ),
    Song(
        title = "Photograph",
        artistName = "Ed Sheeran",
        album = Album(coverId = R.drawable.photograph)
    ),
    Song(
        title = "Cudi Montage",
        artistName = "Kids See Ghosts",
        album = Album(coverId = R.drawable.kids_see_ghosts)
    ),
    Song(
        title = "Break the Chain",
        artistName = "Lupe Fiasco, Eric Turner, Sway",
        album = Album(coverId = R.drawable.lasers)
    ),
    Song(
        title = "Lost",
        artistName = "Frank Ocean",
        album = Album(coverId = R.drawable.frank_ocean)
    )
)
