package com.rey.detail.external.di.module

import com.rey.detail.domain.entity.usecase.MovieDetailUseCase
import com.rey.detail.domain.usecase.MovieDetailUseCaseImpl
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class UseCaseModule {
    @Binds
    @ModuleScope
    abstract fun provideMovieDetailUseCase(detailUseCaseImpl: MovieDetailUseCaseImpl): MovieDetailUseCase
}