package com.telda.domain.usecase

import com.telda.data.utils.BaseDataSource
import com.telda.domain.model.popular.MoviesGateway
import javax.inject.Inject


class MoviesPopularUseCase @Inject constructor(
    private val moviesPopularRepository: MoviesGateway
) :
    BaseDataSource() {

    suspend fun requestPopularMovies() =
        safeApiCall { moviesPopularRepository.requestPopularMovies() }

}