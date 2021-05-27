package com.rey.movies.external.di.module

import com.rey.movies.domain.entity.usecase.AuthUseCase
import com.rey.movies.domain.entity.usecase.MovieUseCase
import com.rey.movies.domain.usecase.MovieUseCaseImpl
import com.rey.movies.domain.usecase.usecase.AuthUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class UseCaseModule {
    @Singleton
    @Binds
    abstract fun provideMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase

    @Singleton
    @Binds
    abstract fun provideAuthenticationUseCase(authUseCaseImpl: AuthUseCaseImpl): AuthUseCase
}