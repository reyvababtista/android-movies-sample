package com.rey.movies.data.repository.source.remote

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.domain.dto.MovieDetailResponse
import com.rey.movies.domain.dto.MovieResponse

internal interface MovieRemoteData {
    suspend fun getMovies(): Result<List<MovieResponse>>
    suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse>
}