package com.rey.list.data.repository

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.list.data.repository.source.remote.MovieRemoteData
import com.rey.list.domain.dto.MovieResponse
import com.rey.list.domain.usecase.repository.MovieRepository
import javax.inject.Inject

internal class MovieRepositoryImpl @Inject constructor(private val remoteData: MovieRemoteData) :
    MovieRepository {
    override suspend fun getMovies(): Result<List<MovieResponse>> = remoteData.getMovies()
}