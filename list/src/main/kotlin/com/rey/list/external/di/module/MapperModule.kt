package com.rey.list.external.di.module

import com.google.gson.Gson
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.list.data.source.remote.api.dto.MovieResponseDTO
import com.rey.list.data.source.remote.mapper.MoviesResponseMapper
import com.rey.list.presentation.dto.MovieResponseUI
import com.rey.list.presentation.mapper.MovieResponseUIMapper
import com.rey.movies.domain.dto.MovieResponse
import com.rey.movies.external.di.annotation.ModuleScope
import dagger.Module
import dagger.Provides

@Module
internal class MapperModule {
    @ModuleScope
    @Provides
    fun provideMoviesRespMapper(gson: Gson): ResponseMapper<List<MovieResponseDTO>, List<MovieResponse>> =
        MoviesResponseMapper(gson)

    @ModuleScope
    @Provides
    fun provideMovieRespUIMapper(): Mapper<List<MovieResponse>, List<MovieResponseUI>> =
        MovieResponseUIMapper()
}