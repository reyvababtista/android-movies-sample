package com.rey.list.presentation.mapper

import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.list.presentation.dto.MovieResponseUI
import com.rey.movies.domain.dto.MovieResponse

class MovieResponseUIMapper : Mapper<List<MovieResponse>, List<MovieResponseUI>> {
    override fun map(model: List<MovieResponse>): List<MovieResponseUI> = model.map { movie ->
        MovieResponseUI(movie.id, movie.poster, "-- ${movie.copyright} --")
    }
}