package com.rey.movies.external.di

import com.rey.movies.domain.entity.usecase.MovieUseCase
import com.rey.movies.external.di.module.*
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ExternalModule::class,
        MapperModule::class,
        BaseNetworkModule::class,
        NetworkModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface ApplicationComponent {
    fun movieUseCase(): MovieUseCase
}