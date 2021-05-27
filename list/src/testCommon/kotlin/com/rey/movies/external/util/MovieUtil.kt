package com.rey.movies.external.util

import com.rey.movies.domain.dto.MovieResponse

object MovieUtil {
    fun generateFakeMoviesResponse(size: Int = 1): List<MovieResponse> =
        (0 until size).map { index ->
            MovieResponse(index, "foo-$index")
        }

    fun generateFakeMovieResponse(id: Int = 0, poster: String = "foo"): MovieResponse =
        MovieResponse(id, poster)
}