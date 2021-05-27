package com.rey.detail.domain.entity.usecase.repository

import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.lib.cleanarch.domain.dto.Result

internal interface MovieDetailRepository {
    suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse>
}