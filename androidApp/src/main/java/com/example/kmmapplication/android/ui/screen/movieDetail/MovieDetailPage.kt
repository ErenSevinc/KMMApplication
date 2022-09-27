package com.example.kmmapplication.android.ui.screen.movieDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
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
        Text(text = this@with?.originalTitle ?: "")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(modifier = Modifier.fillMaxSize()) {

    }
}