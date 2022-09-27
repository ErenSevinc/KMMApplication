package com.example.kmmapplication.android.ui.screen.movieDetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kmmapplication.CommonViewModel

@Composable
fun MovieDetail() {
        Text(text = "ASdasd")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(modifier = Modifier.fillMaxSize()) {
        MovieDetail()
    }
}