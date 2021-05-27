package com.rey.movies.data.source.remote.mapper

import com.google.gson.Gson
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper
import com.rey.movies.data.source.remote.api.dto.MovieDetailResponseDTO
import com.rey.movies.domain.dto.MovieDetailResponse

class MovieDetailResponseMapper(gson: Gson) :
    ResponseMapper<MovieDetailResponseDTO, MovieDetailResponse>(gson) {
    override fun map(model: MovieDetailResponseDTO): MovieDetailResponse = with(model) {
        MovieDetailResponse(id, title, poster, summary, cast, director, year, trailer)
    }
}