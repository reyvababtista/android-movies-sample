package com.rey.movies.data.source.local

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.data.repository.source.local.AuthLocalData
import javax.inject.Inject

internal class AuthLocalDataImpl @Inject constructor() : AuthLocalData {
    override suspend fun userLoggedInStatus(): Result<Boolean> {
        return Result.Success(true)
    }
}