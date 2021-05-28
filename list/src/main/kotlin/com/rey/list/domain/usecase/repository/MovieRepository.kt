package com.rey.list.domain.usecase.repository

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.list.domain.dto.MovieResponse

internal interface MovieRepository {
    suspend fun getMovies(): Result<List<MovieResponse>>
}