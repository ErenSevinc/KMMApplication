package com.example.kmmapplication.android.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.kmmapplication.android.ui.theme.Beige
import com.example.kmmapplication.android.ui.theme.toDate
import com.example.kmmapplication.data.model.MovieItem

@Composable
fun MovieCard(item: MovieItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(430.dp)
            .padding(5.dp)
            .clickable { Log.d("asd","${item.title}") },
        shape = RoundedCornerShape(
            topStart = 5.dp,
            topEnd = 5.dp,
            bottomEnd = 15.dp,
            bottomStart = 15.dp
        ),
        backgroundColor = Beige,
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(330.dp)
                    .background(Color.Black)
            ) {
                val poster = "https://www.themoviedb.org/t/p/w220_and_h330_face"
                val painter = rememberAsyncImagePainter(model = poster + item.posterPath)
                Image(
                    modifier = Modifier.fillMaxWidth().height(330.dp),
                    painter = painter,
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(),
                text = "Movie" ?: ""
            )
            Text(
                modifier = Modifier.padding(),
                text = item.title ?: ""
            )
            Text(
                modifier = Modifier.padding(),
                text = "Release Date" ?: ""
            )
            Text(
                modifier = Modifier.padding(),
                text = item.releaseDate?.toDate() ?: ""
            )
        }
    }

}

