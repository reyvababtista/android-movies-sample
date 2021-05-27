package com.rey.detail.external.di

import com.rey.detail.external.di.module.DetailModule
import com.rey.detail.presentation.fragment.MovieDetailFragment
import com.rey.movies.external.di.ApplicationComponent
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Component

@ModuleScope
@Component(dependencies = [ApplicationComponent::class], modules = [DetailModule::class])
interface DetailComponent {
    @Component.Factory
    interface Factory {
        fun create(applicationComponent: ApplicationComponent): DetailComponent
    }

    fun inject(movieDetailFragment: MovieDetailFragment)
}