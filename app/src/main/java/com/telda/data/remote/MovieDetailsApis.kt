package com.telda.data.remote

import com.telda.BuildConfig
import com.telda.domain.model.movie_details.credit.MovieCreditsResponse
import com.telda.domain.model.movie_details.details.MovieDetailsResponse
import com.telda.domain.model.movies_popular.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailsApis {
    @GET("movie/{movie_id}")
    suspend fun requestMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Response<MovieDetailsResponse>

    @GET("movie/{movie_id}/similar")
    suspend fun requestMovieSimilar(
        @Path("movie_id") movieId: Int,
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Response<MoviesResponse>

    @GET("movie/{movie_id}/credits")
    suspend fun requestMovieCredits(
        @Path("movie_id") movieId: Int,
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY
    ): Response<MovieCreditsResponse>
}