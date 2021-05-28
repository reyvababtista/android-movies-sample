package com.rey.movies.external.di.module

import com.rey.movies.data.repository.source.local.AuthLocalData
import com.rey.movies.data.source.local.AuthLocalDataImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class LocalDataModule {
    @Singleton
    @Binds
    abstract fun provideAuthenticationLocalData(authLocalDataImpl: AuthLocalDataImpl): AuthLocalData
}