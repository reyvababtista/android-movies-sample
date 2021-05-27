package com.rey.list.external.di.module

import androidx.lifecycle.ViewModel
import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.list.presentation.dto.MovieResponseUI
import com.rey.list.presentation.mapper.MovieResponseUIMapper
import com.rey.list.presentation.viewmodel.MovieViewModel
import com.rey.movies.domain.dto.MovieResponse
import com.rey.movies.domain.entity.usecase.MovieUseCase
import com.rey.movies.external.di.annotation.ModuleScope
import com.rey.movies.external.di.annotation.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class ListModule {
    @ModuleScope
    @Provides
    fun provideMovieRespUIMapper(): Mapper<List<MovieResponse>, List<MovieResponseUI>> =
        MovieResponseUIMapper()

    @ModuleScope
    @Provides
    @IntoMap
    @ViewModelKey(MovieViewModel::class)
    fun provideMovieViewModel(
        useCase: MovieUseCase,
        movieRespUIMapper: Mapper<List<MovieResponse>, List<MovieResponseUI>>
    ): ViewModel = MovieViewModel(useCase, movieRespUIMapper)
}