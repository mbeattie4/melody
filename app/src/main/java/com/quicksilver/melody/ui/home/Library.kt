package com.quicksilver.melody.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.quicksilver.melody.ui.theme.green700

@Composable
fun MelodyLibrary(modifier: Modifier = Modifier) {
    Text(text = "LIBRARY", color = green700, modifier = modifier)
}