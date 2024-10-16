package com.kiki.moviesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.kiki.moviesapp.presentation.MovieListViewModel
import com.kiki.moviesapp.presentation.screens.popular.PopularScreen
import com.kiki.moviesapp.presentation.screens.popular.PopularViewModel
import com.kiki.moviesapp.ui.theme.MoviesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val popularViewModel = hiltViewModel<PopularViewModel>()

                    PopularScreen(viewModel = popularViewModel)
                }
            }
        }
    }
}