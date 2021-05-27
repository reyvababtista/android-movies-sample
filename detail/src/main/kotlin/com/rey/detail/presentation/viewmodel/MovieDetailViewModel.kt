package com.rey.detail.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rey.detail.domain.dto.MovieDetailResponse
import com.rey.detail.domain.entity.usecase.MovieDetailUseCase
import com.rey.detail.presentation.dto.MovieDetailResponseUI
import com.rey.lib.cleanarch.domain.dto.Result
import com.rey.lib.cleanarch.domain.dto.errorMessage
import com.rey.lib.cleanarch.domain.mapper.Mapper
import com.rey.movies.external.util.Event
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDetailViewModel(
    private val useCase: MovieDetailUseCase,
    private val movieDetailRespUIMapper: Mapper<MovieDetailResponse, MovieDetailResponseUI>
) : ViewModel() {

    private val _error = MutableLiveData<Event<String>>()
    val error: LiveData<Event<String>> = _error

    private val _detail = MutableLiveData<MovieDetailResponseUI>()
    val detail: LiveData<MovieDetailResponseUI> = _detail

    fun getMovieDetail(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = useCase.getMovieDetail(id)) {
                is Result.Success -> {
                    val uiData = movieDetailRespUIMapper.map(result.data)
                    _detail.postValue(uiData)
                }
                is Result.Error -> _error.postValue(Event(result.errorMessage))
            }
        }
    }
}