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

val samplePlaylists = listOf(
    Playlist(
        coverImageId = R.drawable.signal_noise_playlist_cover,
        name = "Beyond",
        creator = "",
        songs = emptyList()
    ),
    Playlist(
        coverImageId = R.drawable.frank_ocean,
        name = "In The Deep",
        creator = "",
        songs = emptyList()
    ),
    Playlist(
        coverImageId = R.drawable.dr_dre,
        name = "Street Parking",
        creator = "",
        songs = emptyList()
    ),
    Playlist(
        coverImageId = R.drawable.lasers,
        name = "On The Road",
        creator = "",
        songs = emptyList()
    ),
    Playlist(
        coverImageId = R.drawable.photograph,
        name = "Memory Lane",
        creator = "",
        songs = emptyList()
    ),
    Playlist(
        coverImageId = R.drawable.kids_see_ghosts,
        name = "Deep Work",
        creator = "",
        songs = emptyList()
    )
)