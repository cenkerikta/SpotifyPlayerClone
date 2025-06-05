package com.example.spotifyplayerclone

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spotifyplayerclone.ui.theme.MusicBarTextColor
import com.example.spotifyplayerclone.ui.theme.SpecializedButton
import com.example.spotifyplayerclone.ui.theme.SpotifyCloneTheme
import com.example.spotifyplayerclone.ui.theme.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SpotifyCloneTheme {
                Homepage()
            }
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homepage() {
    val sliderState = remember { mutableFloatStateOf(0f) }
    val songDuration = 2.11f

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = (screenWidth / 15).dp, end = (screenWidth / 15).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpecializedButton(
                    R.drawable.ic_arrow, (screenWidth / 12), White
                )
                Text(
                    "Chillin'", color = White, fontSize = (screenWidth / 22).sp
                )
                SpecializedButton(
                    R.drawable.ic_options, (screenWidth / 15), White
                )
            }

            Image(
                painter = painterResource(id = R.drawable.album_cover_v2),
                contentDescription = "",
                Modifier.size((screenWidth / 1.15).dp)
            )
            Spacer(
                modifier = Modifier.height((screenWidth / 20).dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = (screenWidth / 15).dp, end = (screenWidth / 15).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        "Carousel",
                        color = White,
                        fontSize = (screenWidth / 16).sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        "Evgeny Grinko", color = MusicBarTextColor, fontSize = (screenWidth / 22).sp
                    )
                }
                SpecializedButton(
                    R.drawable.ic_add, (screenWidth / 10), White
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = (screenWidth / 15).dp),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                Slider(
                    value = sliderState.floatValue,
                    onValueChange = { sliderState.floatValue = it },
                    valueRange = 0f..songDuration,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                        .height((screenWidth / 15).dp),
                    thumb = {
                        Box(
                            Modifier
                                .size((screenWidth / 20).dp)
                                .background(Color.White, shape = CircleShape)
                        )
                    },
                    track = { sliderState ->
                        Box(Modifier.fillMaxWidth()) {
                            Box(
                                Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.Center)
                                    .height((screenWidth / 100).dp)
                                    .background(MusicBarTextColor, CircleShape)
                            )
                            Box(
                                Modifier
                                    .fillMaxWidth(sliderState.value / sliderState.valueRange.endInclusive)
                                    .height((screenWidth / 100).dp)
                                    .align(Alignment.CenterStart)
                                    .background(Color.White, CircleShape)
                            )
                        }
                    })
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "%.2f".format(sliderState.floatValue),
                        color = MusicBarTextColor,
                        fontSize = (screenWidth / 28).sp
                    )
                    Text(
                        songDuration.toString(),
                        color = MusicBarTextColor,
                        fontSize = (screenWidth / 28).sp
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = (screenWidth / 15).dp, end = (screenWidth / 15).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpecializedButton(
                    R.drawable.ic_shuffle, (screenWidth / 12), White
                )
                SpecializedButton(
                    R.drawable.ic_prev, (screenWidth / 12), White
                )
                SpecializedButton(
                    R.drawable.ic_pause, (screenWidth / 6), White
                )
                SpecializedButton(
                    R.drawable.ic_next, (screenWidth / 12), White
                )
                SpecializedButton(
                    R.drawable.ic_loop, (screenWidth / 12), White
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = (screenWidth / 15).dp, end = (screenWidth / 15).dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpecializedButton(
                    R.drawable.ic_devices, (screenWidth / 15), White
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    SpecializedButton(R.drawable.ic_share, (screenWidth / 15), White)
                    Spacer(modifier = Modifier.size((screenWidth / 50).dp))
                    SpecializedButton(R.drawable.ic_queue, (screenWidth / 15), White)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SpotifyCloneTheme {
        Homepage()
    }
}
