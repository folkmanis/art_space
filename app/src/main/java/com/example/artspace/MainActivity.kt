package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Surface(
            elevation = 2.dp,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.image_1),
                contentDescription = null,
                modifier = Modifier
                    .padding(36.dp)
            )
        }
        Surface(
            elevation = 2.dp,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.title_1),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Light
                )
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(fontWeight = FontWeight.Bold)
                        ) {
                            append(stringResource(id = R.string.author_1))
                        }
                        append(" (")
                        append(stringResource(id = R.string.year_1))
                        append(")")
                    },
                    fontSize = 12.sp,
                )
            }
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp),
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1.0f)
                    .padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.button_previous))
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .weight(1.0f)
                    .padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.button_next))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}