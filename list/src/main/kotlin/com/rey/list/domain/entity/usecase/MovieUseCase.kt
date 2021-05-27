package com.rey.list.domain.entity.usecase

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.domain.dto.MovieResponse

interface MovieUseCase {
    suspend fun getMovies(): Result<List<MovieResponse>>
}