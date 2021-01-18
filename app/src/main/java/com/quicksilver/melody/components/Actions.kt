package com.quicksilver.melody.components

import androidx.compose.animation.ColorPropKey
import androidx.compose.animation.core.TransitionState
import androidx.compose.animation.core.transitionDefinition
import androidx.compose.animation.core.tween
import androidx.compose.animation.transition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.preferredHeight
import androidx.compose.foundation.layout.preferredWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.quicksilver.melody.components.FavoriteState.FAVORITE
import com.quicksilver.melody.components.FavoriteState.NOT_FAVORITE
import com.quicksilver.melody.ui.theme.MelodyTheme
import com.quicksilver.melody.ui.theme.green700
import com.quicksilver.melody.ui.theme.typography

enum class FavoriteState {
    FAVORITE,
    NOT_FAVORITE
}

val iconColor = ColorPropKey(label = "iconColor")

@Composable
fun FavoriteButton(favoriteState: MutableState<FavoriteState>, state: TransitionState? = null) {
    IconButton(
        onClick = {
            favoriteState.value = if (favoriteState.value == NOT_FAVORITE) {
                FAVORITE
            } else {
                NOT_FAVORITE
            }
        }
    ) {
        Icon(
            imageVector = Icons.Default.Favorite,
            tint = state?.get(iconColor) ?: Color.White
        )
    }
}

@Composable
fun AnimatedFavoriteButton() {
    val favoriteState = remember { mutableStateOf(NOT_FAVORITE) }
    val transitionDefinition = transitionDefinition<FavoriteState> {
        state(FAVORITE) {
            this[iconColor] = green700
        }

        state(NOT_FAVORITE) {
            this[iconColor] = Color.White
        }

        transition(NOT_FAVORITE to FAVORITE) {
            iconColor using tween(durationMillis = 1000)
        }

        transition(FAVORITE to NOT_FAVORITE) {
            iconColor using tween(durationMillis = 1000)
        }
    }
    val transitionState = transition(
        definition = transitionDefinition,
        initState = favoriteState.value,
        toState = if (favoriteState.value == NOT_FAVORITE) FAVORITE else NOT_FAVORITE
    )

    FavoriteButton(favoriteState = favoriteState, state = transitionState)
}

@Composable
fun ShuffleButton() {
    Button(
        onClick = { /* Do nothing */ },
        colors = buttonColors(backgroundColor = green700),
        modifier = Modifier
            .preferredWidth(200.dp)
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
        modifier = Modifier
            .preferredWidth(100.dp)
            .preferredHeight(20.dp)
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
fun FavoriteButtonPreview() {
    MelodyTheme {
        FavoriteButton(mutableStateOf(NOT_FAVORITE))
    }
}

@Preview
@Composable
fun AnimatedFavoriteButtonPreview() {
    MelodyTheme {
        AnimatedFavoriteButton()
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