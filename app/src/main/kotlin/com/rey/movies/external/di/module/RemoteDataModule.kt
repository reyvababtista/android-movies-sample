package com.rey.movies.external.di.module

import com.rey.movies.data.repository.source.remote.MovieRemoteData
import com.rey.movies.data.source.remote.MovieRemoteDataImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class RemoteDataModule {
    @Singleton
    @Binds
    abstract fun provideMovieRemoteData(remoteDataImpl: MovieRemoteDataImpl): MovieRemoteData
}