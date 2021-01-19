package com.quicksilver.melody.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quicksilver.melody.components.RecommendationCarousel
import com.quicksilver.melody.model.sampleRecommendations

@Composable
fun MelodySearch(modifier: Modifier = Modifier) {
    RecommendationCarousel(recommendations = sampleRecommendations, modifier = modifier)
}