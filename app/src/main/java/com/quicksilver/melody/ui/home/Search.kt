package com.quicksilver.melody.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quicksilver.melody.ui.theme.green700

@Composable
fun MelodySearch(modifier: Modifier = Modifier) {
    Text(text = "SEARCH", color = green700, modifier = modifier)
}