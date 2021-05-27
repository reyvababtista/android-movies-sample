package com.rey.movies.external.di.module

import com.google.gson.Gson
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.movies.data.source.remote.api.dto.MovieDetailResponseDTO
import com.rey.movies.data.source.remote.api.dto.MovieResponseDTO
import com.rey.movies.data.source.remote.mapper.MovieDetailResponseMapper
import com.rey.movies.data.source.remote.mapper.MoviesResponseMapper
import com.rey.movies.domain.dto.MovieDetailResponse
import com.rey.movies.domain.dto.MovieResponse
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class MapperModule {
    @Singleton
    @Provides
    fun provideMoviesRespMapper(gson: Gson): ResponseMapper<List<MovieResponseDTO>, List<MovieResponse>> =
        MoviesResponseMapper(gson)

    @Singleton
    @Provides
    fun provideMovieDetailRespMapper(gson: Gson): ResponseMapper<MovieDetailResponseDTO, MovieDetailResponse> =
        MovieDetailResponseMapper(gson)
}