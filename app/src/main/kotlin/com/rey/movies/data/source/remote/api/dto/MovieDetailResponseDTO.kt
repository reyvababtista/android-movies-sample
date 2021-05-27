package com.rey.movies.data.source.remote.api.dto

data class MovieDetailResponseDTO(
    val id: Int,
    val title: String,
    val poster: String,
    val summary: String,
    val cast: String,
    val director: String,
    val year: Int,
    val trailer: String
)