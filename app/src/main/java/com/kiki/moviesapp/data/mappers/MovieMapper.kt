package com.kiki.moviesapp.data.mappers

import com.kiki.moviesapp.data.local.movie.MovieEntity
import com.kiki.moviesapp.data.remote.respond.MovieDto
import com.kiki.moviesapp.domain.model.Movie

fun MovieDto.toMovieEntity(
    category: String
) : MovieEntity {
    return MovieEntity(
        adult = adult ?: false,
        backdrop_path = backdrop_path ?: "",
        original_language = original_language ?: "",
        overview = overview ?: "",
        poster_path = poster_path ?: "",
        release_date = release_date ?: "",
        title = title ?: "",
        vote_average = vote_average ?: 0.0,
        popularity = popularity ?: 0.0,
        vote_count = vote_count ?: 0,
        id = id ?: -1,
        original_title = original_title ?: "",
        video = video ?: false,

        category = category,

        genre_ids = genre_ids?.map { it.toInt() } ?: listOf(-1, -2)
    )
}

fun MovieEntity.toMovie(
    category: String
) : Movie {
    return Movie (
        backdrop_path = backdrop_path,
        original_language = original_language,
        overview = overview,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        vote_average = vote_average,
        popularity = popularity,
        vote_count = vote_count,
        video = video,
        id = id,
        adult = adult,
        original_title = original_title,

        category = category,

        genre_ids = genre_ids
    )
}