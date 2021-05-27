package com.rey.detail.external.di.module

import com.rey.detail.data.source.remote.api.MovieDetailService
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal class NetworkModule {
    @ModuleScope
    @Provides
    fun provideDetailService(retrofit: Retrofit): MovieDetailService =
        retrofit.create(MovieDetailService::class.java)
}