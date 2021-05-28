package com.rey.movies.domain.usecase

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.domain.entity.usecase.AuthUseCase
import com.rey.movies.domain.usecase.repository.AuthRepository
import javax.inject.Inject

internal class AuthUseCaseImpl @Inject constructor(private val repository: AuthRepository) :
    AuthUseCase {
    override suspend fun isUserLoggedIn(): Result<Boolean> = repository.userLoggedInStatus()
}