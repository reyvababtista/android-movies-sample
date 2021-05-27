package com.rey.list.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.errorMessage
import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.list.domain.entity.usecase.MovieUseCase
import com.rey.list.presentation.dto.MovieResponseUI
import com.rey.movies.domain.dto.MovieResponse
import com.rey.movies.external.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(
    private val useCase: MovieUseCase,
    private val moviesRespUIMapper: Mapper<List<MovieResponse>, List<MovieResponseUI>>
) : ViewModel() {

    private val _error = MutableLiveData<Event<String>>()
    val error: LiveData<Event<String>> = _error

    private val _movies = MutableLiveData<List<MovieResponseUI>>()
    val movies: LiveData<List<MovieResponseUI>> = _movies

    fun getMovies() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = useCase.getMovies()) {
            is Result.Success -> {
                val uiData = moviesRespUIMapper.map(result.data)
                _movies.postValue(uiData)
            }
            is Result.Error -> _error.postValue(Event(result.errorMessage))
        }
    }
}