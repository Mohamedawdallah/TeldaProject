package com.telda.data.remote

import com.telda.BuildConfig
import com.telda.domain.model.popular.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApis {
    @GET("movie/popular")
    suspend fun requestPopularMovies(
        @Query("api_key")
        apiKey: String = BuildConfig.API_KEY,
    ): Response<MoviesResponse>
}