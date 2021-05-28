package com.rey.movies.external.di.module

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
internal class BaseNetworkModule {
    @Singleton
    @Provides
    fun provideMovieRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/android10/Sample-Data/master/Android-CleanArchitecture-Kotlin/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}