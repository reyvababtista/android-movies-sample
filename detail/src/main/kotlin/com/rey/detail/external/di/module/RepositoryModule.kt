package com.rey.detail.external.di.module

import com.rey.detail.data.repository.MovieDetailRepositoryImpl
import com.rey.detail.domain.entity.usecase.repository.MovieDetailRepository
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class RepositoryModule {
    @Binds
    @ModuleScope
    abstract fun provideDetailRepository(movieDetailRepositoryImpl: MovieDetailRepositoryImpl): MovieDetailRepository
}