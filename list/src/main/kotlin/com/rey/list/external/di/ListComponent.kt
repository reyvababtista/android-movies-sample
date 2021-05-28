package com.rey.list.external.di

import com.rey.list.external.di.module.*
import com.rey.list.presentation.fragment.MoviesFragment
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
        ViewModelModule::class]
)
interface ListComponent {
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): ListComponent
    }

    fun inject(moviesFragment: MoviesFragment)
}