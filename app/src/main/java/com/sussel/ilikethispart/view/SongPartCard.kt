package com.sussel.ilikethispart.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material.icons.sharp.PlayArrow
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.sharp.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sussel.ilikethispart.R
import kotlin.random.Random

@Preview(showBackground = true)
@Composable
fun SongPartItem() {
    var isPlaying by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.onSurface)
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(2.dp)),
        elevation = CardDefaults
            .cardElevation(
                defaultElevation = 4.dp
            ),
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
        ) {
            val image: Painter = painterResource(id = R.drawable.vinyl_cover)

            Image(
                modifier = Modifier
                    .background(Color.Gray)
                    .size(80.dp)
                    .clip(MaterialTheme.shapes.medium),
                painter = image,
                alignment = Alignment.CenterStart,
                contentDescription = ""
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "A Long Band Name - A Long Song Name (A normal album)",
                        modifier = Modifier.weight(1f, fill = false),
                        fontSize = 12.sp,
                        maxLines = 4
                    )
                    Icon(
                        imageVector = Icons.Sharp.Share,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                    Icon(
                        imageVector = Icons.Sharp.FavoriteBorder,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = { isPlaying = !isPlaying }) {
                        Icon(
                            imageVector = (if (isPlaying) Icons.Sharp.Settings else Icons.Sharp.PlayArrow),
                            contentDescription = if (isPlaying) "Pause" else "Play"
                        )
                    }
                    Slider(
                        value = Random.nextDouble(1.0, 10.0).toFloat(),
                        valueRange = 0f..10f,
                        onValueChange = {},
                        modifier = Modifier.weight(1f)
                    )
                    IconButton(onClick = { /* Mudo */ }) {
                        Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
                    }
                }
            }
        }
    }
}