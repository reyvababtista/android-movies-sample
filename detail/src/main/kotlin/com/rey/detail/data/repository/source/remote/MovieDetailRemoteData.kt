package com.rey.detail.data.repository.source.remote

import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.lib.cleanarch.domain.dto.Result

internal interface MovieDetailRemoteData {
    suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse>
}