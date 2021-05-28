package com.rey.list.external.di.module

import com.rey.list.data.source.remote.api.MovieService
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
internal class NetworkModule {
    @ModuleScope
    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)
}