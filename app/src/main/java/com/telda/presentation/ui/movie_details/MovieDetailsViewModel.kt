package com.telda.presentation.ui.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.telda.data.utils.Resource
import com.telda.domain.model.movie_details.credit.MovieCreditsResponse
import com.telda.domain.model.movie_details.details.MovieDetailsResponse
import com.telda.domain.model.movies_popular.MoviesResponse
import com.telda.domain.usecase.details.MovieCreditsUseCase
import com.telda.domain.usecase.details.MovieDetailsUseCase
import com.telda.domain.usecase.details.MovieSimilarUseCase
import com.telda.presentation.utils.Event
import com.telda.presentation.utils.manager.ResponseManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor(
    private val responseManager: ResponseManager,
    private val movieDetailsUseCase: MovieDetailsUseCase,
    private val movieSimilarUseCase: MovieSimilarUseCase,
    private val movieCreditsUseCase: MovieCreditsUseCase
) : ViewModel() {

    private val _observeMovieDetailsSuccess = MutableLiveData<Event<MovieDetailsResponse>>()
    private val _observeMovieSimilarSuccess = MutableLiveData<Event<MoviesResponse>>()
    private val _observeMovieCastSuccess = MutableLiveData<Event<MovieCreditsResponse>>()
    private val _observeClose = MutableLiveData<Event<Boolean>>()

    fun handleMovieDetailsApis(movieId: Int) {
        responseManager.loading()
        viewModelScope.launch {
            val firstSectionRequest = async { movieDetailsUseCase.requestMovieDetails(movieId) }
            val secondSectionRequest = async { movieCreditsUseCase.requestMovieCredits(movieId) }
            val thirdSectionRequest = async { movieSimilarUseCase.requestMovieSimilar(movieId) }

            requestMovieDetails(firstSectionRequest.await())
            requestMovieCredits(secondSectionRequest.await())
            requestMovieSimilar(thirdSectionRequest.await())
        }

    }

    private fun requestMovieDetails(movieDetails: Resource<MovieDetailsResponse>) {
        when (val response = movieDetails) {
            is Resource.Success -> {
                responseManager.hideLoading()
                _observeMovieDetailsSuccess.value = Event(response.data!!)
            }
            is Resource.Failed -> {
                responseManager.hideLoading()
            }
            else -> responseManager.noConnection()

        }
    }

    private fun requestMovieSimilar(movie: Resource<MoviesResponse>) {
        responseManager.loading()
        when (val response = movie) {
            is Resource.Success -> {
                responseManager.hideLoading()
                _observeMovieSimilarSuccess.value = Event(response.data!!)
            }
            is Resource.Failed -> {
                responseManager.hideLoading()
            }
            else -> responseManager.noConnection()
        }
    }


    private fun requestMovieCredits(movieCredits: Resource<MovieCreditsResponse>) {
        when (val response = movieCredits) {
            is Resource.Success -> {
                responseManager.hideLoading()
                _observeMovieCastSuccess.value = Event(response.data!!)
            }
            is Resource.Failed -> {
                responseManager.hideLoading()
            }
            else -> responseManager.noConnection()
        }

    }

    fun onCloseClicked() {
        _observeClose.value = Event(true)
    }

    //Getters:
    val observeMovieDetailsSuccess: LiveData<Event<MovieDetailsResponse>>
        get() = _observeMovieDetailsSuccess

    val observeMovieSimilarSuccess: LiveData<Event<MoviesResponse>>
        get() = _observeMovieSimilarSuccess

    val observeMovieCastSuccess: LiveData<Event<MovieCreditsResponse>>
        get() = _observeMovieCastSuccess

    val observeClose: LiveData<Event<Boolean>>
        get() = _observeClose

}