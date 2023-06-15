package com.rey.list.data.source.remote

import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import com.rey.list.data.repository.source.remote.MovieRemoteData
import com.rey.list.data.source.remote.api.MovieService
import com.rey.list.data.source.remote.api.dto.MovieResponseDTO
import com.rey.list.domain.dto.MovieResponse
import javax.inject.Inject

internal class MovieRemoteDataImpl @Inject constructor(
    private val service: MovieService,
    private val moviesRespMapper: ResponseMapper<List<MovieResponseDTO>, List<MovieResponse>>
) : MovieRemoteData {
    override suspend fun getMovies(): Result<List<MovieResponse>> = suspendTryCatch {
        val dto = service.getMovies()
        moviesRespMapper.mapResponse(dto)
    }
}