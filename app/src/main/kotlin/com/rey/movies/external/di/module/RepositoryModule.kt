package com.rey.movies.external.di.module

import com.rey.movies.data.repository.MovieRepositoryImpl
import com.rey.movies.domain.usecase.repository.MovieRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun provideMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}