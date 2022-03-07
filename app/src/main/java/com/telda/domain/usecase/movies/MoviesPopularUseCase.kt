package com.telda.domain.usecase.movies

import com.telda.data.utils.BaseDataSource
import com.telda.domain.model.movies_popular.MoviesGateway
import javax.inject.Inject

class MoviesPopularUseCase @Inject constructor(
    private val moviesPopularRepository: MoviesGateway
) :
    BaseDataSource() {

    suspend fun requestPopularMovies() =
        safeApiCall { moviesPopularRepository.requestPopularMovies() }

}