package com.rey.list.domain.entity.usecase

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.list.domain.dto.MovieResponse

interface MovieUseCase {
    suspend fun getMovies(): Result<List<MovieResponse>>
}