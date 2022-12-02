package com.example.kmmapplication.android.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kmmapplication.android.ui.screen.movieDetail.MovieDetail
import com.example.kmmapplication.android.ui.screen.movieList.MoviesPage

@Composable
fun MainNavigation(navController: NavHostController, toolbarTitle: MutableState<String>) {

    NavHost(navController = navController, startDestination = "moviesPage") {
        composable("moviesPage") {
            toolbarTitle.value = "Popüler Filmler"
            MoviesPage(navController = navController)
        }
        composable(
            route = "movieDetailPage/{movieId}",
            arguments = listOf(navArgument("movieId") {
                type = NavType.LongType
            })
        ) {
            toolbarTitle.value = "Film Detay"
            MovieDetail(navController = navController, it.arguments?.getLong("movieId") ?: -1)
        }
    }
}