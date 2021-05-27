package com.rey.detail.external.di.module

import androidx.lifecycle.ViewModel
import com.rey.detail.domain.entity.usecase.MovieDetailUseCase
import com.rey.detail.domain.usecase.MovieDetailUseCaseImpl
import com.rey.detail.presentation.dto.MovieDetailResponseUI
import com.rey.detail.presentation.mapper.MovieDetailResponseUIMapper
import com.rey.detail.presentation.viewmodel.MovieDetailViewModel
import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.movies.domain.dto.MovieDetailResponse
import com.rey.movies.domain.entity.usecase.AuthUseCase
import com.rey.movies.domain.entity.usecase.MovieUseCase
import com.rey.movies.external.di.annotation.ModuleScope
import com.rey.movies.external.di.annotation.ViewModelKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
internal class DetailModule {
    @ModuleScope
    @Provides
    fun provideMovieDetailUseCase(
        authUseCase: AuthUseCase,
        movieUseCase: MovieUseCase
    ): MovieDetailUseCase = MovieDetailUseCaseImpl(authUseCase, movieUseCase)

    @ModuleScope
    @Provides
    fun provideMovieDetailRespUIMapper(): Mapper<MovieDetailResponse, MovieDetailResponseUI> =
        MovieDetailResponseUIMapper()

    @ModuleScope
    @Provides
    @IntoMap
    @ViewModelKey(MovieDetailViewModel::class)
    fun provideMovieDetailViewModel(
        useCase: MovieDetailUseCase,
        movieDetailRespUIMapper: Mapper<MovieDetailResponse, MovieDetailResponseUI>
    ): ViewModel = MovieDetailViewModel(useCase, movieDetailRespUIMapper)
}