package com.telda.domain.model.movies_popular

import retrofit2.Response

interface MoviesGateway {
    suspend fun requestPopularMovies(): Response<MoviesResponse>
    suspend fun requestSearchMovies(searchText: String): Response<MoviesResponse>
}