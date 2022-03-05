package com.telda.domain.usecase.movies

import com.telda.data.utils.BaseDataSource
import com.telda.domain.model.movies_popular.MoviesGateway
import javax.inject.Inject

class MoviesSearchUseCase @Inject constructor(
    private val moviesRepository: MoviesGateway
) : BaseDataSource() {

    suspend fun requestSearchMovies(searchText: String) =
        safeApiCall { moviesRepository.requestSearchMovies(searchText) }

}