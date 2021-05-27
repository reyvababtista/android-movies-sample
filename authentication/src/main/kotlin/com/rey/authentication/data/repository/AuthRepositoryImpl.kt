package com.rey.authentication.data.repository

import com.rey.authentication.data.repository.source.local.AuthLocalData
import com.rey.authentication.domain.usecase.repository.AuthRepository
import com.rey.lib.cleanarch.domain.dto.Result

internal class AuthRepositoryImpl(private val localData: AuthLocalData) : AuthRepository {
    override suspend fun userLoggedInStatus(): Result<Boolean> = localData.userLoggedInStatus()
}