package com.rey.list.external.di.module

import com.rey.list.data.repository.source.remote.MovieRemoteData
import com.rey.list.data.source.remote.MovieRemoteDataImpl
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class RemoteDataModule {
    @ModuleScope
    @Binds
    abstract fun provideMovieRemoteData(remoteDataImpl: MovieRemoteDataImpl): MovieRemoteData
}