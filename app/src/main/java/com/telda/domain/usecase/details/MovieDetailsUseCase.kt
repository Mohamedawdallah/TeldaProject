package com.telda.domain.usecase.details

import com.telda.data.utils.BaseDataSource
import com.telda.domain.model.movie_details.MovieDetailsGateway
import javax.inject.Inject

class MovieDetailsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsGateway
) : BaseDataSource() {
    suspend fun requestMovieDetails(movieId: Int) =
        safeApiCall { movieDetailsRepository.requestMovieDetails(movieId) }
}