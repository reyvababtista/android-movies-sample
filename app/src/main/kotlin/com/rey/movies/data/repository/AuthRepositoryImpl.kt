package com.rey.movies.data.repository

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.data.repository.source.local.AuthLocalData
import com.rey.movies.domain.usecase.usecase.repository.AuthRepository
import javax.inject.Inject

internal class AuthRepositoryImpl @Inject constructor(private val localData: AuthLocalData) :
    AuthRepository {
    override suspend fun userLoggedInStatus(): Result<Boolean> = localData.userLoggedInStatus()
}