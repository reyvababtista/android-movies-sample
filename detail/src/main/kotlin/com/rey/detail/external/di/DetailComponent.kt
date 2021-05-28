package com.rey.detail.external.di

import com.rey.detail.external.di.module.*
import com.rey.detail.presentation.fragment.MovieDetailFragment
import com.rey.movies.external.di.ApplicationComponent
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Component

@ModuleScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [
        MapperModule::class,
        NetworkModule::class,
        RemoteDataModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ViewModelModule::class
    ]
)
interface DetailComponent {
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): DetailComponent
    }

    fun inject(movieDetailFragment: MovieDetailFragment)
}