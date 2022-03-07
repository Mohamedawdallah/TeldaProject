package com.telda.data.repository

import com.telda.data.remote.MovieDetailsApis
import com.telda.domain.model.movie_details.MovieDetailsGateway
import com.telda.domain.model.movie_details.credit.MovieCreditsResponse
import com.telda.domain.model.movie_details.details.MovieDetailsResponse
import com.telda.domain.model.movies_popular.MoviesResponse
import retrofit2.Response
import javax.inject.Inject

class MovieDetailsRepository @Inject constructor(
    private val api: MovieDetailsApis
) : MovieDetailsGateway {
    override suspend fun requestMovieDetails(movieId: Int): Response<MovieDetailsResponse> =
        api.requestMovieDetails(movieId)


    override suspend fun requestMovieSimilar(movieId: Int): Response<MoviesResponse> =
        api.requestMovieSimilar(movieId)


    override suspend fun requestMovieCredit(movieId: Int): Response<MovieCreditsResponse> =
        api.requestMovieCredits(movieId)

}