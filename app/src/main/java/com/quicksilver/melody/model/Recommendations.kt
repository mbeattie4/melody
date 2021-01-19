package com.quicksilver.melody.model

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import com.quicksilver.melody.R

data class Recommendation(
    val label: String,
    @DrawableRes val coverImageId: Int,
    val backgroundColor: Color = Color.Cyan,
    val textColor: Color = Color.White
)

val sampleRecommendations = listOf(
    Recommendation(
        label = "Hip Hop",
        coverImageId = R.drawable.dr_dre,
        backgroundColor = Color.Cyan
    ),
    Recommendation(
        label = "Alternative",
        coverImageId = R.drawable.kids_see_ghosts,
        backgroundColor = Color.Magenta
    ),
    Recommendation(
        label = "Rap",
        coverImageId = R.drawable.lasers,
        backgroundColor = Color.Blue
    ),
    Recommendation(
        label = "Emotional",
        coverImageId = R.drawable.photograph,
        backgroundColor = Color.Gray
    ),
    Recommendation(
        label = "Pop",
        coverImageId = R.drawable.chainsmokers,
        backgroundColor = Color.Yellow
    ),
)