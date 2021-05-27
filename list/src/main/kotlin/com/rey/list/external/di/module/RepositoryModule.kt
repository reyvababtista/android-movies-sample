package com.rey.list.external.di.module

import com.rey.list.data.repository.MovieRepositoryImpl
import com.rey.list.domain.usecase.repository.MovieRepository
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class RepositoryModule {
    @ModuleScope
    @Binds
    abstract fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository

}