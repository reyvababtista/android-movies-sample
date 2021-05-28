package com.rey.movies.data.source.remote

import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.UNKNOWN_ERROR
import com.rey.lib.cleanarch.domain.dto.suspendTryCatch
import com.rey.list.data.repository.source.remote.MovieRemoteData
import com.rey.list.domain.dto.MovieResponse

class FakeMovieRemoteDataImpl(
    private val throwError: Boolean = false,
    private val movieList: List<MovieResponse> = emptyList()
) : MovieRemoteData {
    override suspend fun getMovies(): Result<List<MovieResponse>> = suspendTryCatch {
        if (throwError) throw Exception(UNKNOWN_ERROR)
        Result.Success(movieList)
    }
}