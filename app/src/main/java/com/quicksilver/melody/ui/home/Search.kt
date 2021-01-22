package com.quicksilver.melody.ui.home

import androidx.compose.foundation.layout.Arrangement.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksilver.melody.components.RecommendationSection
import com.quicksilver.melody.components.SearchBar
import com.quicksilver.melody.components.VerticalSpace
import com.quicksilver.melody.model.sampleSections

@Composable
fun MelodySearch(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        VerticalSpace(height = 4.dp)
        Text(
            text = "Search",
            style = MaterialTheme.typography.h4.copy(color = Color.White),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
        VerticalSpace(height = 8.dp)
        SearchBar(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp))
        VerticalSpace(height = 4.dp)
        LazyColumn(
            contentPadding = PaddingValues(top = 8.dp, bottom = 8.dp),
            verticalArrangement = spacedBy(8.dp)
        ) {
            items(sampleSections) { section -> RecommendationSection(section = section) }
        }
    }
}

@Preview
@Composable
fun MelodySearchPreview() {
    MelodySearch()
}