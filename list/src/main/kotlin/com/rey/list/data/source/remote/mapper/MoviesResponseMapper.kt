package com.rey.list.data.source.remote.mapper

import com.google.gson.Gson
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.list.domain.dto.MovieResponse
import javax.inject.Inject

internal class MoviesResponseMapper @Inject constructor(gson: Gson) :
    ResponseMapper<List<com.rey.list.data.source.remote.api.dto.MovieResponseDTO>, List<MovieResponse>>(
        gson
    ) {
    override fun map(model: List<com.rey.list.data.source.remote.api.dto.MovieResponseDTO>): List<MovieResponse> =
        model.map { dto ->
            MovieResponse(dto.id, dto.poster)
        }
}