package com.rey.detail.domain.entity.usecase

import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.lib.cleanarch.domain.dto.Result

interface MovieDetailUseCase {
    suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse>
}