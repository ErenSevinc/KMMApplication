package com.example.kmmapplication.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.kmmapplication.android.ui.MainNavigation

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route ?: ""

            val toolbarTitle = remember { mutableStateOf("") }

            Scaffold(
                topBar = {
                    if (toolbarTitle.value != "") {
                        TopAppBar(
                            title = {
                                    Text(
                                        text = toolbarTitle.value,
                                        textAlign = TextAlign.Right
                                    )
                            },
                            navigationIcon = getNavigationIcon(
                                route = currentRoute,
                                navController = navController
                            )
                        )
                    }
                }
            ) {
                MainNavigation(navController, toolbarTitle)
            }
        }
    }

    @Composable
    fun getNavigationIcon(route: String, navController: NavController): @Composable (() -> Unit)? {
        return if (route.isNotEmpty() && route != "moviesPage") {
            {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back Icon")
                }
            }
        } else {
            null
        }
    }
}