package com.quicksilver.melody.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksilver.melody.ui.theme.MelodyTheme
import com.quicksilver.melody.ui.theme.green700
import com.quicksilver.melody.ui.theme.typography

@Composable
fun ShuffleButton() {
    Button(
        onClick = { /* Do nothing */ },
        colors = buttonColors(backgroundColor = green700),
        modifier = Modifier.preferredWidth(200.dp)
            .clip(CircleShape)
    ) {
        Text(
            text = "SHUFFLE PLAY",
            style = typography.h6.copy(fontSize = 14.sp),
            color = Color.White,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
    }
}

@Composable
fun HollowButton() {
    OutlinedButton(
        onClick = { /* Do nothing */ },
        shape = RoundedCornerShape(
            topLeftPercent = 50,
            topRightPercent = 50,
            bottomLeftPercent = 50,
            bottomRightPercent = 50
        ),
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),
        contentPadding = PaddingValues(bottom = 1.dp),
        modifier = Modifier.preferredWidth(100.dp).preferredHeight(20.dp)
    ) {
        Text(
            text = "ADD SONGS",
            style = typography.h6.copy(fontSize = 10.sp),
            color = Color.White
        )
    }
}

@Preview
@Composable
fun ShuffleButtonPreview() {
    MelodyTheme {
        ShuffleButton()
    }
}

@Preview
@Composable
fun HollowButtonPreview() {
    MelodyTheme {
        HollowButton()
    }
}