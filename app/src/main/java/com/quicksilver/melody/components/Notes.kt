package com.quicksilver.melody.components

import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.quicksilver.melody.ui.theme.MelodyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

data class Note(
    val id: String,
    val title: String,
    val subtitle: String
)

@Composable
fun NoteItems(
    notes: List<Note>,
    modifier: Modifier = Modifier,
    navigateTo: (String) -> Unit = {}
) {
    ScrollableColumn(modifier = modifier) {
        notes.forEach { note ->
            NoteItem(
                id = note.id,
                title = note.title,
                subtitle = note.subtitle,
                navigateTo = navigateTo
            )
            NoteItemDivider()
        }
    }
}

@Composable
fun NoteItem(id: String, title: String, subtitle: String, navigateTo: (String) -> Unit = {}) {
    Row(
        modifier = Modifier.clickable(onClick = { navigateTo(id) })
            .padding(16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(end = 8.dp)
                .align(Alignment.CenterVertically)
                .weight(weight = 1.0f)
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun NoteDetails(title: String) {
    Card(
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        backgroundColor = Color.Cyan,
        elevation = 6.dp,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Surface(
                shape = CircleShape,
                modifier = Modifier.align(Alignment.CenterHorizontally)
                    .preferredSize(size = 60.dp)
            ) {
                CoilImage(
                    data = "https://upload.wikimedia.org/wikipedia/en/4/4e/Wonder_Woman_1984.png",
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = title,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
fun NoteItemDivider() {
    Divider(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.08f)
    )
}

@Preview
@Composable
fun NoteItemsPreview() {
    MelodyTheme {
        NoteItems(notes = fakeNotes)
    }
}

@Preview
@Composable
fun NoteItemPreview() {
    MelodyTheme {
        NoteItem(id = "0", title = "Wonder Woman", subtitle = "1984")
    }
}

@Preview
@Composable
fun NoteDetailsPreview() {
    MelodyTheme {
        NoteDetails(title = "Wonder Woman")
    }
}

val fakeNotes: List<Note> = listOf(
    Note(id = "0", title = "Wonder Woman", subtitle = "1984"),
    Note(id = "1", title = "Tenet", subtitle = "Beyond Time"),
    Note(id = "2", title = "The Alienist", subtitle = "Angel of Darkness"),
    Note(id = "3", title = "Planet Earth", subtitle = "Discovery"),
    Note(id = "4", title = "Good Will Hunting", subtitle = "Legendary")
)