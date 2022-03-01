package com.telda.domain.model.popular

import retrofit2.Response

interface MoviesGateway {
    suspend fun requestPopularMovies(): Response<MoviesResponse>
}