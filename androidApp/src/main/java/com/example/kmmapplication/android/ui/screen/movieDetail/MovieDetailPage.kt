package com.example.kmmapplication.android.ui.screen.movieDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.kmmapplication.android.ui.screen.movieList.IMAGE_BASE_URL
import com.example.kmmapplication.android.ui.theme.Beige
import com.example.kmmapplication.presentation.viewmodel.MovieDetailViewModel

@Composable
fun MovieDetail(navController: NavController, movieId: Long) {
    val viewModel: MovieDetailViewModel = viewModel()
    val detail by viewModel.movieDetail.collectAsState()

    LaunchedEffect(detail) {
        if (detail == null) {
            viewModel.getMovieDetail(movieId)
        }
    }

    with(detail) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier
                    .width(220.dp)
                    .height(330.dp)
                    .padding(16.dp)
                    .background(Beige)
            ) {
                val poster = IMAGE_BASE_URL + detail?.backdropPath
                val painter = rememberAsyncImagePainter(model = poster)
                Image(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    painter = painter,
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center,
                text = this@with?.title ?: ""
            )
            Text(
                modifier = Modifier.padding(8.dp),
                textAlign = TextAlign.Justify,
                text = this@with?.overview ?: ""
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(modifier = Modifier.fillMaxSize()) {

    }
}