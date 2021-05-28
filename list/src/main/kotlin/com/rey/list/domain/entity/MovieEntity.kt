package com.rey.list.domain.entity

import com.rey.list.domain.dto.MovieResponse

internal const val COPYRIGHT = "android10"

internal fun addCopyright(movies: List<MovieResponse>) = movies.map { movie ->
    MovieResponse(movie.id, movie.poster, COPYRIGHT)
}