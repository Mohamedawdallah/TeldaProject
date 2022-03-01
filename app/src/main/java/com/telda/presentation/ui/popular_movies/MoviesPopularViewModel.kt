package com.telda.presentation.ui.popular_movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telda.data.utils.Resource
import com.telda.domain.model.popular.Movie
import com.telda.domain.model.popular.MoviesResponse
import com.telda.domain.usecase.MoviesPopularUseCase
import com.telda.presentation.utils.Event
import com.telda.presentation.utils.manager.ResponseManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesPopularViewModel @Inject constructor(
    private val responseManager: ResponseManager,
    private val moviesPopularUseCase: MoviesPopularUseCase
) : ViewModel() {
    private val _observeMoviesPopularSuccess = MutableLiveData<Event<MoviesResponse>>()

    init {
        requestMovies()
    }

    private fun requestMovies() {
        responseManager.loading()
        viewModelScope.launch {
            when (val response = moviesPopularUseCase.requestPopularMovies()) {
                is Resource.Success -> {
                    responseManager.hideLoading()
                    _observeMoviesPopularSuccess.value = Event(response.data!!)
                }
                is Resource.Failed -> {
                    responseManager.hideLoading()
                }
                else -> responseManager.noConnection()
            }
        }
    }

    //Clicks:
    fun onMovieClick(movieObject: Movie) {

    }

    //Getters:
    val observeMoviePopularSuccess: LiveData<Event<MoviesResponse>>
        get() = _observeMoviesPopularSuccess

}