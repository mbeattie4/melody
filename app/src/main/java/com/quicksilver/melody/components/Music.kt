package com.quicksilver.melody.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.quicksilver.melody.R
import com.quicksilver.melody.model.Recommendation
import com.quicksilver.melody.model.sampleRecommendations
import com.quicksilver.melody.ui.theme.MelodyTheme

@Composable
fun AlbumCover(@DrawableRes imageId: Int, modifier: Modifier = Modifier) {
    Image(
        imageResource(id = imageId),
        contentScale = ContentScale.Crop,
        modifier = modifier
            .preferredSize(60.dp)
            .clip(shape = RoundedCornerShape(4.dp))
    )
}

@Composable
fun SongTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        color = Color.White,
        fontSize = TextUnit.Sp(14),
        modifier = modifier
    )
}

@Composable
fun ArtistName(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        color = Color.Gray,
        fontSize = TextUnit.Sp(10),
        modifier = modifier
    )
}

@Composable
fun OptionsIcon(modifier: Modifier = Modifier) {
    Icon(
        imageVector = Icons.Filled.MoreVert,
        tint = Color.Gray,
        modifier = modifier
            .preferredHeight(20.dp)
            .wrapContentWidth()
    )
}

@Composable
fun SongRow(
    @DrawableRes albumCoverId: Int,
    songTitle: String,
    artistName: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AlbumCover(imageId = albumCoverId, modifier = Modifier.padding(end = 8.dp))
        Column(
            modifier = Modifier
                .weight(1.0f)
                .padding(bottom = 2.dp)
        ) {
            SongTitle(title = songTitle)
            ArtistName(name = artistName)
        }
        OptionsIcon()
    }
}

@Composable
fun RecommendationCard(
    recommendation: Recommendation,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .preferredWidth(160.dp)
            .preferredHeight(90.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(color = recommendation.backgroundColor)
    ) {
        Box(
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        0.0f to Color.Black.copy(alpha = 0.8f),
                        100.0f to Color.Transparent
                    )
                )
                .fillMaxSize()
        )
        Text(
            text = recommendation.label,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit.Sp(18),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(start = 8.dp, top = 8.dp)
        )
        Card(
            shape = RoundedCornerShape(4.dp),
            elevation = 4.dp,
            modifier = Modifier
                .preferredSize(70.dp)
                .align(Alignment.BottomEnd)
                .rotate(20f)
        ) {
            Image(
                bitmap = imageResource(id = recommendation.coverImageId),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Composable
fun RecommendationCarousel(
    recommendations: List<Recommendation>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = spacedBy(8.dp),
        contentPadding = PaddingValues(start = 8.dp, end = 8.dp)
    ) {
        items(recommendations) { recommendation -> RecommendationCard(recommendation) }
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationPreview() {
    MelodyTheme {
        RecommendationCard(
            recommendation = sampleRecommendations.first(),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RecommendationCarouselPreview() {
    MelodyTheme {
        RecommendationCarousel(
            recommendations = sampleRecommendations,
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
    }
}

@Preview
@Composable
fun AlbumCoverPreview() {
    MelodyTheme {
        AlbumCover(imageId = R.drawable.g_easy)
    }
}

@Preview
@Composable
fun SongTitlePreview() {
    MelodyTheme {
        SongTitle(title = "Crash & Burn")
    }
}

@Preview
@Composable
fun ArtistNamePreview() {
    MelodyTheme {
        ArtistName(name = "G-Easy, Kehlani")
    }
}

@Preview
@Composable
fun OptionsIconPreview() {
    MelodyTheme {
        OptionsIcon()
    }
}

@Preview
@Composable
fun SongRowPreview() {
    MelodyTheme {
        SongRow(
            albumCoverId = R.drawable.g_easy,
            songTitle = "Crash & Burn",
            artistName = "G-Easy, Kehlani",
            modifier = Modifier.padding(8.dp)
        )
    }
}