package com.rey.detail.external.di.module

import androidx.lifecycle.ViewModel
import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.detail.domain.entity.usecase.MovieDetailUseCase
import com.rey.detail.presentation.dto.MovieDetailResponseUI
import com.rey.detail.presentation.viewmodel.MovieDetailViewModel
import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.movies.external.di.annotation.ModuleScope
import com.rey.movies.external.di.annotation.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
internal class ViewModelModule {

    @ModuleScope
    @Provides
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    fun provideMovieDetailViewModel(
        useCase: MovieDetailUseCase,
        movieDetailRespUIMapper: Mapper<MovieDetailResponse, MovieDetailResponseUI>
    ): ViewModel = MovieDetailViewModel(useCase, movieDetailRespUIMapper)
}