package com.example.kmmapplication.android.ui.screen.movieList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kmmapplication.data.model.MovieItem
import com.example.kmmapplication.presentation.IsSuccess
import com.example.kmmapplication.presentation.viewmodel.MoviesPageViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun MoviesPage(navController: NavController) {

    val viewModel = getViewModel<MoviesPageViewModel>()
    val movies by viewModel.popularMovies.collectAsState()
    val isSuccess by viewModel.isSuccess.collectAsState()

    LaunchedEffect(movies) {
        if (movies == null) {
            viewModel.getPopularMovies()
        }
    }

    with(movies) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            when (isSuccess) {
                IsSuccess.LOADING -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp, 50.dp),
                        color = Color.Red
                    )
                }
                IsSuccess.SUCCESS -> {
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
                IsSuccess.FAIL -> {
                    Text("Error !!!")
                }
            }
        }
    }
}


