package com.rey.movies.domain.usecase

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.data
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import com.rey.movies.domain.dto.MovieDetailResponse
import com.rey.movies.domain.dto.MovieResponse
import com.rey.movies.domain.entity.addCopyright
import com.rey.movies.domain.entity.usecase.MovieUseCase
import com.rey.movies.domain.usecase.repository.MovieRepository
import javax.inject.Inject

internal class MovieUseCaseImpl @Inject constructor(private val repository: MovieRepository) :
    MovieUseCase {
    override suspend fun getMovies(): Result<List<MovieResponse>> = suspendTryCatch {
        val response = addCopyright(repository.getMovies().data)
        Result.Success(response)
    }

    override suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse> =
        repository.getMovieDetail(id)
}