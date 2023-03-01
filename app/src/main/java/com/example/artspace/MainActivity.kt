package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
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
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {

    var currentImage by remember {
        mutableStateOf(1)
    }

    when (currentImage) {
        1 -> ArtSpaceScreen(
            image = R.drawable.image_1,
            title = R.string.title_1,
            author = R.string.author_1,
            year = R.string.year_1,
            onPreviousImage = { currentImage = 3 },
            onNextImage = { currentImage = 2 }
        )
        2 -> ArtSpaceScreen(
            image = R.drawable.image_2,
            title = R.string.title_2,
            author = R.string.author_2,
            year = R.string.year_2,
            onPreviousImage = { currentImage = 1 },
            onNextImage = { currentImage = 3 }
        )
        3 -> ArtSpaceScreen(
            image = R.drawable.image_3,
            title = R.string.title_3,
            author = R.string.author_3,
            year = R.string.year_3,
            onPreviousImage = { currentImage = 2 },
            onNextImage = { currentImage = 1 }
        )
    }

}

@Composable
fun ArtSpaceScreen(
    @DrawableRes image: Int,
    @StringRes title: Int,
    @StringRes author: Int,
    @StringRes year: Int,
    onPreviousImage: () -> Unit,
    onNextImage: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .weight(1f)
                .padding(16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
            ) {
                Surface(
                    elevation = 2.dp,
                    modifier = Modifier
                        .border(width = 2.dp, color = Color.Gray)
                        .weight(1f, fill = false)
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(36.dp)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Surface(
                    elevation = 2.dp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                ) {
                    ImageAnnotation(
                        title, author, year
                    )
                }

            }
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = modifier
                .padding(8.dp)
        ) {
            Button(
                onClick = onPreviousImage,
                modifier = modifier
                    .weight(1.0f)
                    .padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.button_previous))
            }
            Button(
                onClick = onNextImage,
                modifier = modifier
                    .weight(1.0f)
                    .padding(8.dp)
            ) {
                Text(text = stringResource(id = R.string.button_next))
            }
        }

    }
}


@Composable
fun ImageAnnotation(
    @StringRes title: Int,
    @StringRes author: Int,
    @StringRes year: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .padding(8.dp)
    ) {
        Text(
            text = stringResource(id = title),
            fontSize = 24.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(fontWeight = FontWeight.Bold)
                ) {
                    append(stringResource(id = author))
                }
                append(" (")
                append(stringResource(id = year))
                append(")")
            },
            fontSize = 12.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}