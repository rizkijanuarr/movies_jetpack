package com.kiki.moviesapp.presentation.screens.popular

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PopularScreen(
    viewModel: PopularViewModel = hiltViewModel()
) {


    val movieListState by viewModel.movieListState.collectAsState()

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            if (movieListState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))

            } else {
                LazyColumn(modifier = Modifier.padding(16.dp)) {
                    items(movieListState.popularMovieList) { movie ->
                        Text(
                            text = movie.title ?: "No Title",
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                    }
                }
            }

        }
    }
}