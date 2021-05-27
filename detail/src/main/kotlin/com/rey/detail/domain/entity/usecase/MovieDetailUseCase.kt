package com.rey.detail.domain.entity.usecase

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.domain.dto.MovieDetailResponse

interface MovieDetailUseCase {
    suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse>
}