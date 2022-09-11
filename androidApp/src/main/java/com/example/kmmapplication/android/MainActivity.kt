package com.example.kmmapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import com.example.kmmapplication.CommonViewModel

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: CommonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[CommonViewModel::class.java]

        setContent {
            val movies by viewModel.popularMovies.collectAsState()

            with(movies) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = this@with?.results?.get(0)?.overview.toString(),
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}