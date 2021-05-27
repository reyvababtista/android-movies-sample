package com.rey.movies.data.source.remote

import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import com.rey.movies.data.repository.source.remote.MovieRemoteData
import com.rey.movies.data.source.remote.api.MovieService
import com.rey.movies.data.source.remote.api.dto.MovieDetailResponseDTO
import com.rey.movies.data.source.remote.api.dto.MovieResponseDTO
import com.rey.movies.domain.dto.MovieDetailResponse
import com.rey.movies.domain.dto.MovieResponse
import javax.inject.Inject

internal class MovieRemoteDataImpl @Inject constructor(
    private val service: MovieService,
    private val moviesRespMapper: ResponseMapper<List<MovieResponseDTO>, List<MovieResponse>>,
    private val movieDetailRespMapper: ResponseMapper<MovieDetailResponseDTO, MovieDetailResponse>
) : MovieRemoteData {
    override suspend fun getMovies(): Result<List<MovieResponse>> = suspendTryCatch {
        val dto = service.getMovies()
        moviesRespMapper.mapResponse(dto)
    }

    override suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse> = suspendTryCatch {
        val dto = service.movieDetails(id)
        movieDetailRespMapper.mapResponse(dto)
    }
}