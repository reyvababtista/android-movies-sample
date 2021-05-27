package com.rey.authentication.data.repository.source.local

import com.rey.lib.cleanarch.domain.dto.Result

internal interface AuthLocalData {
    suspend fun userLoggedInStatus(): Result<Boolean>
}