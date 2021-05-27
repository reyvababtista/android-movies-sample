package com.rey.movies.data.source.remote.api

import com.rey.movies.data.source.remote.api.dto.MovieDetailResponseDTO
import com.rey.movies.data.source.remote.api.dto.MovieResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MovieService {
    companion object {
        private const val MOVIE_ID = "movieId"
        private const val MOVIES = "movies.json"
        private const val MOVIE_DETAILS = "movie_0{$MOVIE_ID}.json"
    }

    @GET(MOVIES)
    suspend fun getMovies(): Response<List<MovieResponseDTO>>

    @GET(MOVIE_DETAILS)
    fun movieDetails(@Path(MOVIE_ID) id: Int): Response<MovieDetailResponseDTO>
}