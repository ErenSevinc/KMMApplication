package com.example.kmmapplication.android.ui.screen.movieList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kmmapplication.android.ui.screen.movieList.MovieCard
import com.example.kmmapplication.data.model.MovieItem


@Composable
fun MovieListPage(movieList: MutableList<MovieItem>) {

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(movieList) { item ->
                MovieCard(item)
            }
        }
    }

}

