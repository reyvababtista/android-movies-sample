package com.rey.movies.external.di.module

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class ExternalModule {
    @Singleton
    @Provides
    fun provideGson(): Gson = Gson()
}