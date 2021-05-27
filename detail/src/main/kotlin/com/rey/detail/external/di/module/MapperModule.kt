package com.rey.detail.external.di.module

import com.google.gson.Gson
import com.rey.detail.data.source.remote.api.dto.MovieDetailResponseDTO
import com.rey.detail.data.source.remote.mapper.MovieDetailResponseMapper
import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.detail.presentation.dto.MovieDetailResponseUI
import com.rey.detail.presentation.mapper.MovieDetailResponseUIMapper
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Module
import dagger.Provides

@Module
internal class MapperModule {
    @ModuleScope
    @Provides
    fun provideMovieDetailRespUIMapper(): Mapper<MovieDetailResponse, MovieDetailResponseUI> =
        MovieDetailResponseUIMapper()

    @ModuleScope
    @Provides
    fun provideMovieDetailRespMapper(gson: Gson): ResponseMapper<MovieDetailResponseDTO, MovieDetailResponse> =
        MovieDetailResponseMapper(gson)
}