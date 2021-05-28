package com.rey.detail.data.source.remote.api

import com.rey.detail.data.source.remote.api.dto.MovieDetailResponseDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface MovieDetailService {
    companion object {
        private const val MOVIE_ID = "movieId"
        private const val MOVIE_DETAILS = "movie_0{${MOVIE_ID}}.json"
    }

    @GET(MOVIE_DETAILS)
    suspend fun movieDetails(@Path(MOVIE_ID) id: Int): Response<MovieDetailResponseDTO>
}