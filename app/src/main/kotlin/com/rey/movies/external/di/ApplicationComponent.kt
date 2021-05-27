package com.rey.movies.external.di

import com.google.gson.Gson
import com.rey.movies.domain.entity.usecase.AuthUseCase
import com.rey.movies.domain.entity.usecase.MovieUseCase
import com.rey.movies.external.di.module.*
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ExternalModule::class,
        MapperModule::class,
        BaseNetworkModule::class,
        NetworkModule::class,
        LocalDataModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface ApplicationComponent {
    fun gson(): Gson
    fun retrofit(): Retrofit
    fun movieUseCase(): MovieUseCase
    fun authUseCase(): AuthUseCase
}