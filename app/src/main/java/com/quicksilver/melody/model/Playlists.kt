package com.quicksilver.melody.model

import androidx.annotation.DrawableRes
import com.quicksilver.melody.R

data class Playlist(
    @DrawableRes val coverImageId: Int,
    val name: String,
    val creator: String,
    val songs: List<Song>
)

val samplePlaylist: Playlist = Playlist(
    coverImageId = R.drawable.signal_noise_playlist_cover,
    name = "Beyond",
    creator = "mbeattie4",
    songs = sampleSongs
)