package com.rey.list.domain.dto

data class MovieResponse(
    val id: Int,
    val poster: String,
    val copyright: String = ""
)
