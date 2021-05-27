package com.rey.detail.data.repository

import com.rey.detail.data.repository.source.remote.MovieDetailRemoteData
import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.detail.domain.entity.usecase.repository.MovieDetailRepository
import com.rey.lib.cleanarch.domain.dto.Result
import javax.inject.Inject

internal class MovieDetailRepositoryImpl @Inject constructor(private val remoteData: MovieDetailRemoteData) :
    MovieDetailRepository {

    override suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse> =
        remoteData.getMovieDetail(id)
}