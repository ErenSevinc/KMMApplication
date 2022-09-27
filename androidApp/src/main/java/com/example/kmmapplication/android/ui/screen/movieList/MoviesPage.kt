package com.example.kmmapplication.android.ui.screen.movieList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kmmapplication.data.model.MovieItem
import com.example.kmmapplication.presentation.viewmodel.MoviesPageViewModel


@Composable
fun MoviesPage(navController: NavController) {

    val viewModel: MoviesPageViewModel = viewModel()
    val movies by viewModel.popularMovies.collectAsState()

    LaunchedEffect(movies) {
        if (movies == null) {
            viewModel.getPopularMovies()
        }
    }

    with(movies) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
//            if (1 == 1) {
//                CircularProgressIndicator(
//                    modifier = Modifier.size(50.dp, 50.dp),
//                    color = Color.Red
//                )
//            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(this@with?.results ?: emptyList<MovieItem>().toMutableList()) { item ->
                    MovieCard(item) {
                        navController.navigate("movieDetailPage/${it}")
                    }
                }
            }
        }
    }
}

