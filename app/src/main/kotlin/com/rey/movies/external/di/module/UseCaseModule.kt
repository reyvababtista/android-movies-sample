package com.rey.movies.external.di.module

import com.rey.movies.domain.entity.usecase.AuthUseCase
import com.rey.movies.domain.usecase.AuthUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class UseCaseModule {
    @Singleton
    @Binds
    abstract fun provideAuthenticationUseCase(authUseCaseImpl: AuthUseCaseImpl): AuthUseCase
}