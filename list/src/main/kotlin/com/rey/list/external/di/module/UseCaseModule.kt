package com.rey.list.external.di.module

import com.rey.list.domain.entity.usecase.MovieUseCase
import com.rey.list.domain.usecase.MovieUseCaseImpl
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class UseCaseModule {
    @ModuleScope
    @Binds
    abstract fun provideMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}