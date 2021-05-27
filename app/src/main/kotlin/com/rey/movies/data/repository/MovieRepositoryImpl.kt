package com.rey.movies.data.repository

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.data.repository.source.remote.MovieRemoteData
import com.rey.movies.domain.dto.MovieResponse
import com.rey.movies.domain.usecase.repository.MovieRepository

internal class MovieRepositoryImpl(private val remoteData: MovieRemoteData) : MovieRepository {
    override suspend fun getMovies(): Result<List<MovieResponse>> = remoteData.getMovies()
}