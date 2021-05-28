package com.rey.movies.domain.entity.usecase

import com.rey.lib.cleanarch.domain.dto.Result

interface AuthUseCase {
    suspend fun isUserLoggedIn(): Result<Boolean>
}