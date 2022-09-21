package com.example.kmmapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.kmmapplication.CommonViewModel
import com.example.kmmapplication.android.ui.screen.MovieListPage
import com.example.kmmapplication.data.model.MovieItem

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: CommonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CommonViewModel::class.java]

        setContent {
            val movies by viewModel.popularMovies.collectAsState()

            with(movies) {
                MovieListPage(
                    movieList = this@with?.results ?: emptyList<MovieItem>().toMutableList()
                )
            }
        }
    }
}


//            with(movies) {
//                Box(
//                    modifier = Modifier.fillMaxSize(),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(
//                        text = this@with?.results?.get(0)?.overview.toString(),
//                        fontSize = 18.sp
//                    )
//                }
//            }