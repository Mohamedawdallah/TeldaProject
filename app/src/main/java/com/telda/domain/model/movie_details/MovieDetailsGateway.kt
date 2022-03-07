package com.telda.domain.model.movie_details

import com.telda.domain.model.movie_details.credit.MovieCreditsResponse
import com.telda.domain.model.movie_details.details.MovieDetailsResponse
import com.telda.domain.model.movies_popular.MoviesResponse
import retrofit2.Response

interface MovieDetailsGateway {
    suspend fun requestMovieDetails(movieId: Int): Response<MovieDetailsResponse>
    suspend fun requestMovieSimilar(movieId: Int): Response<MoviesResponse>
    suspend fun requestMovieCredit(movieId: Int): Response<MovieCreditsResponse>
}