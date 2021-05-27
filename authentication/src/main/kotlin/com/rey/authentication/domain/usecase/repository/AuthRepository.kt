package com.rey.authentication.domain.usecase.repository

import com.rey.lib.cleanarch.domain.dto.Result

internal interface AuthRepository {
    suspend fun userLoggedInStatus(): Result<Boolean>
}