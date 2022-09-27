package com.example.kmmapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.example.kmmapplication.CommonViewModel
import com.example.kmmapplication.android.ui.screen.movieList.MovieListPage
import com.example.kmmapplication.data.model.MovieItem

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: CommonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CommonViewModel::class.java]

        setContent {
            val movies by viewModel.popularMovies.collectAsState()
            var success = false

            with(movies) {

                if (this@with?.results != null) {
                    success = true
                }
                MovieListPage(
                    movieList = this@with?.results ?: emptyList<MovieItem>().toMutableList(),
                    isSuccess = success
                )
            }
        }
    }
}