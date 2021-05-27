package com.rey.movies.domain.usecase.usecase.repository

import com.rey.lib.cleanarch.domain.dto.Result

internal interface AuthRepository {
    suspend fun userLoggedInStatus(): Result<Boolean>
}