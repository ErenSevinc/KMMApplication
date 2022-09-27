package com.example.kmmapplication.android.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kmmapplication.android.ui.screen.movieDetail.MovieDetail
import com.example.kmmapplication.android.ui.screen.movieList.MoviesPage

@Composable
fun MainNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "moviesPage") {
        composable("moviesPage") {
            MoviesPage(navController = navController)
        }
        composable(
            route = "movieDetailPage/{movieId}",
            arguments = listOf(navArgument("movieId") {
                type = NavType.LongType
            })
        ) {
            MovieDetail(navController = navController, it.arguments?.getLong("movieId") ?: -1)
        }
    }
}