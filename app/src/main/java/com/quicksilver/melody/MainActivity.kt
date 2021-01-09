package com.quicksilver.melody

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import com.quicksilver.melody.components.NewsStory
import com.quicksilver.melody.ui.MelodyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MelodyApp {
                NewsStory()
            }
        }
    }
}

@Composable
fun MelodyApp(content: @Composable () -> Unit) {
    MelodyTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}

@Preview
@Composable
fun MelodyAppPreview() {
    MelodyApp {
        NewsStory()
    }
}