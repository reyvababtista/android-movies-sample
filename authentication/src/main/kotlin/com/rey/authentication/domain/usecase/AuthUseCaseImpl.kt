package com.rey.authentication.domain.usecase

import com.rey.authentication.domain.usecase.repository.AuthRepository
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.domain.entity.usecase.AuthUseCase

internal class AuthUseCaseImpl(private val repository: AuthRepository) : AuthUseCase {
    override suspend fun isUserLoggedIn(): Result<Boolean> = repository.userLoggedInStatus()
}