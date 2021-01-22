package com.quicksilver.melody.ui.home

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.melody.ui.theme.green700

@Composable
fun MelodyHome(modifier: Modifier = Modifier) {
    Text(text = "HOME", color = green700, modifier = modifier)
}

@Preview
@Composable
fun MelodyHomePreview() {
    MelodyHome()
}