package com.example.kmmapplication.android.ui.screen.movieDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.kmmapplication.android.ui.screen.movieList.IMAGE_BASE_URL
import com.example.kmmapplication.android.ui.screen.movieList.IMAGE_POST_BASE
import com.example.kmmapplication.android.ui.theme.Beige
import com.example.kmmapplication.android.ui.theme.toDate
import com.example.kmmapplication.presentation.IsSuccess
import com.example.kmmapplication.presentation.viewmodel.MovieDetailViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun MovieDetail(navController: NavController, movieId: Long) {
    val viewModel = getViewModel<MovieDetailViewModel>()
    val detail by viewModel.movieDetail.collectAsState()
    val isSuccess by viewModel.isSuccess.collectAsState()

    LaunchedEffect(detail) {
        viewModel.getMovieDetail(movieId)
    }

    when (isSuccess) {
        IsSuccess.LOADING -> {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp, 50.dp),
                    color = Color.Red
                )
            }
        }
        IsSuccess.FAIL -> {
            Text(text = "Error !!!")
        }
        IsSuccess.SUCCESS -> {
            with(detail) {
                var genres = ""
                var companies = ""
                this?.genres?.forEach { item ->
                    genres += "${item.name}, "
                }
                this?.productionCompanies?.forEach { item ->
                    companies += "${item.name}, "
                }
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .padding(2.dp)
                    ) {
                        val poster = IMAGE_POST_BASE + detail?.backdropPath
                        val painter = rememberAsyncImagePainter(model = poster)
                        Image(
                            modifier = Modifier
                                .fillMaxSize(),
                            painter = painter,
                            contentDescription = ""
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        text = this@with?.title ?: "",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                        Text(
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Center,
                            text = this@with?.tagline ?: " Müthiş bir film...",
                            fontSize = 16.sp
                        )
                        Text(
                            modifier = Modifier.padding(8.dp),
                            textAlign = TextAlign.Justify,
                            text = this@with?.overview ?: "",
                            fontSize = 16.sp
                        )
                        TitleSetView(
                            title = "Filmin Orjinal Adı",
                            text = this@with?.originalTitle ?: "Original Title"
                        )
                        TitleSetView(
                            title = "Tarih",
                            text = this@with?.releaseDate?.toDate() ?: "Release Date"
                        )
                        TitleSetView(
                            title = "Ortalama Puan",
                            text = this@with?.voteAverage.toString()
                        )
                        TitleSetView(title = "Kategori", text = genres.dropLast(2))
                        TitleSetView(title = "Yapımcı", text = companies.dropLast(2))
                    }
                }
            }
        }
    }
}


@Composable
fun TitleSetView(title: String, text: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = text,
            textAlign = TextAlign.Center,
            fontSize = 14.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Box(modifier = Modifier.fillMaxSize()) {

    }
}