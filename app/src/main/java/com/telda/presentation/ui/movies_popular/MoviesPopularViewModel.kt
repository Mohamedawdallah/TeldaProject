package com.telda.presentation.ui.movies_popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telda.data.utils.Resource
import com.telda.domain.model.movies_popular.Movie
import com.telda.domain.model.movies_popular.MoviesResponse
import com.telda.domain.usecase.movies.MoviesPopularUseCase
import com.telda.domain.usecase.movies.MoviesSearchUseCase
import com.telda.presentation.utils.Event
import com.telda.presentation.utils.manager.ResponseManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesPopularViewModel @Inject constructor(
    private val responseManager: ResponseManager,
    private val moviesPopularUseCase: MoviesPopularUseCase,
    private val moviesSearchUseCase: MoviesSearchUseCase
) : ViewModel() {


    private val _observeMoviesPopularSuccess = MutableLiveData<Event<MoviesResponse>>()
    private val _observeMoviesSearchSuccess = MutableLiveData<Event<MoviesResponse>>()
    private val _observeMovieClicked = MutableLiveData<Event<Movie>>()


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


    fun moviesSearch(query: String) {
        responseManager.loading()
        viewModelScope.launch {
            when (val response = moviesSearchUseCase.requestSearchMovies(query)) {
                is Resource.Success -> {
                    responseManager.hideLoading()
                    _observeMoviesSearchSuccess.value = Event(response.data!!)
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
        _observeMovieClicked.value = Event(movieObject)
    }

    //Getters:
    val observeMoviePopularSuccess: LiveData<Event<MoviesResponse>>
        get() = _observeMoviesPopularSuccess

    val observeMovieSearchSuccess: LiveData<Event<MoviesResponse>>
        get() = _observeMoviesSearchSuccess

    val observeMovieClicked: LiveData<Event<Movie>>
        get() = _observeMovieClicked
}