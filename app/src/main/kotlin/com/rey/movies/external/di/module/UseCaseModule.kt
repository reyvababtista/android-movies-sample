package com.rey.movies.external.di.module

import com.rey.movies.domain.entity.usecase.MovieUseCase
import com.rey.movies.domain.usecase.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class UseCaseModule {
    @Singleton
    @Binds
    abstract fun provideMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}