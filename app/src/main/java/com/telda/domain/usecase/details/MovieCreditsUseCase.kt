package com.telda.domain.usecase.details

import com.telda.data.utils.BaseDataSource
import com.telda.domain.model.movie_details.MovieDetailsGateway
import javax.inject.Inject

class MovieCreditsUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsGateway
) : BaseDataSource() {
    suspend fun requestMovieCredits(movieId: Int) =
        safeApiCall { movieDetailsRepository.requestMovieCredit(movieId) }
}