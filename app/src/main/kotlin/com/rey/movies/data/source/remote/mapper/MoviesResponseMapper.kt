package com.rey.movies.data.source.remote.mapper

import com.google.gson.Gson
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.movies.data.source.remote.api.dto.MovieResponseDTO
import com.rey.movies.domain.dto.MovieResponse

internal class MoviesResponseMapper(gson: Gson) :
    ResponseMapper<List<MovieResponseDTO>, List<MovieResponse>>(gson) {
    override fun map(model: List<MovieResponseDTO>): List<MovieResponse> = model.map { dto ->
        MovieResponse(dto.id, dto.poster)
    }
}