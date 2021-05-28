package com.rey.movies.external.di.module

import com.rey.movies.data.repository.AuthRepositoryImpl
import com.rey.movies.domain.usecase.repository.AuthRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideAuthRepository(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}