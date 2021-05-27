package com.rey.movies.domain.entity

import com.rey.movies.domain.dto.MovieResponse

internal const val COPYRIGHT = "imdb"

internal fun addCopyright(movies: List<MovieResponse>) = movies.map { movie ->
    MovieResponse(movie.id, movie.poster, COPYRIGHT)
}