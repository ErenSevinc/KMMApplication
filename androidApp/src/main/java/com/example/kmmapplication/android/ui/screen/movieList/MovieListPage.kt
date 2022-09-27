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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.kmmapplication.android.ui.screen.movieList.MovieCard
import com.example.kmmapplication.data.model.MovieItem


@Composable
fun MovieListPage(movieList: MutableList<MovieItem>, isSuccess: Boolean) {

    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        if (!isSuccess) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp, 50.dp),
                color = Color.Red
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(2)
        ) {
            items(movieList) { item ->
                MovieCard(item)
            }
        }
    }

}

