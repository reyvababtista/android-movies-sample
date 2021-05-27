package com.rey.authentication.data.source.local

import com.rey.authentication.data.repository.source.local.AuthLocalData
import com.rey.lib.cleanarch.domain.dto.Result

internal class AuthLocalDataImpl : AuthLocalData {
    override suspend fun userLoggedInStatus(): Result<Boolean> {
        return Result.Success(true)
    }
}