package com.rey.list.data.repository.source.remote

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.list.domain.dto.MovieResponse

internal interface MovieRemoteData {
    suspend fun getMovies(): Result<List<MovieResponse>>
}