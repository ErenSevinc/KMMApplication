package com.example.kmmapplication.android.ui.screen.movieList

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
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.kmmapplication.android.ui.theme.Beige
import com.example.kmmapplication.android.ui.theme.toDate
import com.example.kmmapplication.data.model.MovieItem

const val IMAGE_BASE_URL = "https://www.themoviedb.org/t/p/w220_and_h330_face"
const val IMAGE_POST_BASE = "https://www.themoviedb.org/t/p/w500_and_h282_face/"

@Composable
fun MovieCard(item: MovieItem, onClick: (itemId: Long) -> Unit ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(380.dp)
            .padding(5.dp)
            .clickable {
                Log.d("asd","${item.id}")
                onClick.invoke(item.id ?: -1) },
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
            ) {
                val poster = IMAGE_BASE_URL + item.posterPath
                val painter = rememberAsyncImagePainter(model = poster)
                Image(
                    modifier = Modifier.fillMaxWidth().height(330.dp),
                    painter = painter,
                    contentDescription = ""
                )
            }
            Text(
                modifier = Modifier.padding(),
                text = "Film" ?: ""
            )
            Text(
                text = item.title ?: "",
                fontSize = 12.sp
            )
        }
    }

}

