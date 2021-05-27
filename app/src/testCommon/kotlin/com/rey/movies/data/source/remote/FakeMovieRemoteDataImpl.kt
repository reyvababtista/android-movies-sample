package com.rey.movies.data.source.remote

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.UNKNOWN_ERROR
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import com.rey.movies.data.repository.source.remote.MovieRemoteData
import com.rey.movies.domain.dto.MovieResponse

class FakeMovieRemoteDataImpl(
    val throwError: Boolean = false,
    val movieList: List<MovieResponse> = emptyList()
) : MovieRemoteData {
    override suspend fun getMovies(): Result<List<MovieResponse>> = suspendTryCatch {
        if (throwError) throw Exception(UNKNOWN_ERROR)
        Result.Success(movieList)
    }
}