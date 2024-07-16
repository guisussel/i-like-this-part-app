package com.sussel.ilikethispart.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material.icons.sharp.PlayArrow
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.sharp.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sussel.ilikethispart.R
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun SongPartItem() {

    var isPlaying by remember { mutableStateOf(false) }
    val image: Painter = painterResource(id = R.drawable.vinyl_cover)
    var sliderPosition by remember { mutableFloatStateOf(Random.nextDouble(1.0, 10.0).toFloat()) }

    Card(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onSurface)
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .background(Color.LightGray)
        ) {
            Image(
                modifier = Modifier
                    .background(Color.LightGray)
                    .size(80.dp),
                painter = image,
                contentDescription = "album cover"
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .weight(1f)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "A very long band name - A ver long song name (with album extras)",
                        modifier = Modifier.weight(1f, fill = true),
                        fontSize = 10.sp,
                        textAlign = TextAlign.Center,
                        fontStyle = FontStyle.Italic,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        style = LocalTextStyle.current.copy(lineHeight = 12.sp)
                    )
                    IconButton(onClick = { /* Share */ }) {
                        Icon(
                            imageVector = Icons.Sharp.Share,
                            contentDescription = null,
                        )
                    }
                    IconButton(onClick = { /* Favorite */ }) {
                        Icon(
                            imageVector = Icons.Sharp.FavoriteBorder,
                            contentDescription = null,
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { isPlaying = !isPlaying }) {
                        Icon(
                            imageVector = (if (isPlaying) Icons.Sharp.Settings else Icons.Sharp.PlayArrow),
                            contentDescription = if (isPlaying) "Pause" else "Play"
                        )
                    }
                    Slider(
                        value = sliderPosition,
                        valueRange = 0f..10f,
                        onValueChange = { sliderPosition = it },
                        enabled = true,
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = { /* Mute */ }) {
                        Icon(
                            imageVector = Icons.Filled.Settings,
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ItemListScreen() {
    val items = List(5) { "Item #$it" }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        items(items) {
            SongPartItem()
        }
    }
}