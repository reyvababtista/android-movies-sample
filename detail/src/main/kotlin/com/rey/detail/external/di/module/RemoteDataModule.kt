package com.rey.detail.external.di.module

import com.rey.detail.data.repository.source.remote.MovieDetailRemoteData
import com.rey.detail.data.source.remote.MovieDetailRemoteDataImpl
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Binds
import dagger.Module

@Module
internal abstract class RemoteDataModule {
    @Binds
    @ModuleScope
    abstract fun provideDetailRemoteData(detailRemoteDataImpl: MovieDetailRemoteDataImpl): MovieDetailRemoteData
}