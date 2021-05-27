package com.rey.detail.presentation.mapper

import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.detail.presentation.dto.MovieDetailResponseUI
import com.rey.lib.cleanarch.domain.mapper.Mapper

class MovieDetailResponseUIMapper : Mapper<MovieDetailResponse, MovieDetailResponseUI> {
    override fun map(model: MovieDetailResponse): MovieDetailResponseUI = with(model) {
        MovieDetailResponseUI(id, title, poster, summary)
    }
}