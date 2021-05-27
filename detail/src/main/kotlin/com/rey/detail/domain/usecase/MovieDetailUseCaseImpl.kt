package com.rey.detail.domain.usecase

import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.detail.domain.entity.usecase.MovieDetailUseCase
import com.rey.detail.domain.entity.usecase.repository.MovieDetailRepository
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.data
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import com.rey.movies.domain.entity.usecase.AuthUseCase
import javax.inject.Inject

internal class MovieDetailUseCaseImpl @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val repository: MovieDetailRepository
) : MovieDetailUseCase {
    override suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse> = suspendTryCatch {
        val userLoggedIn = authUseCase.isUserLoggedIn().data
        if (userLoggedIn) {
            val movieDetail = repository.getMovieDetail(id).data
            Result.Success(movieDetail)
        } else throw IllegalStateException("user not logged in")
    }
}