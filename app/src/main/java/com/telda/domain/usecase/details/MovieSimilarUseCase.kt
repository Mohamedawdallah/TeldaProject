package com.telda.domain.usecase.details

import com.telda.data.utils.BaseDataSource
import com.telda.domain.model.movie_details.MovieDetailsGateway
import javax.inject.Inject

class MovieSimilarUseCase @Inject constructor(
    private val movieDetailsRepository: MovieDetailsGateway
) : BaseDataSource() {
    suspend fun requestMovieSimilar(movieId: Int) =
        safeApiCall { movieDetailsRepository.requestMovieSimilar(movieId) }
}