package com.rey.movies.data.repository.source.remote

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.movies.domain.dto.MovieResponse

interface MovieRemoteData {
    suspend fun getMovies(): Result<MovieResponse>
}