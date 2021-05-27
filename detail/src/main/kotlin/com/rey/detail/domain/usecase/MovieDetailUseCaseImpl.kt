package com.rey.detail.domain.usecase

import com.rey.detail.domain.entity.usecase.MovieDetailUseCase
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.data
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import com.rey.movies.domain.dto.MovieDetailResponse
import com.rey.movies.domain.entity.usecase.AuthUseCase
import com.rey.movies.domain.entity.usecase.MovieUseCase

internal class MovieDetailUseCaseImpl(
    private val authUseCase: AuthUseCase,
    private val movieUseCase: MovieUseCase
) : MovieDetailUseCase {
    override suspend fun getMovieDetail(id: Int): Result<MovieDetailResponse> = suspendTryCatch {
        val userLoggedIn = authUseCase.isUserLoggedIn().data
        if (userLoggedIn) {
            val movieDetail = movieUseCase.getMovieDetail(id).data
            Result.Success(movieDetail)
        } else throw IllegalStateException("user not logged in")
    }
}