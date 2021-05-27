package com.rey.detail.data.source.remote.mapper

import com.google.gson.Gson
import com.rey.detail.data.source.remote.api.dto.MovieDetailResponseDTO
import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.lib.cleanarch.data.source.remote.mapper.ResponseMapper

class MovieDetailResponseMapper(gson: Gson) :
    ResponseMapper<MovieDetailResponseDTO, MovieDetailResponse>(gson) {
    override fun map(model: MovieDetailResponseDTO): MovieDetailResponse = with(model) {
        MovieDetailResponse(
            id,
            title,
            poster,
            summary,
            cast,
            director,
            year,
            trailer
        )
    }
}