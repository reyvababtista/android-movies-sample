package com.rey.movies.data.source.remote.api

import com.rey.movies.data.source.remote.api.dto.MovieDTO
import retrofit2.Response
import retrofit2.http.GET

internal interface MovieService {
    companion object {
        private const val MOVIES = "movies.json"
    }

    @GET(MOVIES)
    suspend fun getMovies(): Response<MovieDTO>
}