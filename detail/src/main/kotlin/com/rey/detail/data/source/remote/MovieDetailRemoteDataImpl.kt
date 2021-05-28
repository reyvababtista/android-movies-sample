package com.rey.detail.data.source.remote

import com.rey.detail.data.repository.source.remote.MovieDetailRemoteData
import com.rey.detail.data.source.remote.api.MovieDetailService
import com.rey.detail.data.source.remote.api.dto.MovieDetailResponseDTO
import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import javax.inject.Inject

internal class MovieDetailRemoteDataImpl @Inject constructor(
    private val service: MovieDetailService,
    private val movieDetailRespMapper: ResponseMapper<MovieDetailResponseDTO, MovieDetailResponse>
) : MovieDetailRemoteData {

    override suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse> = suspendTryCatch {
        val dto = service.movieDetails(id)
        movieDetailRespMapper.mapResponse(dto)
    }
}