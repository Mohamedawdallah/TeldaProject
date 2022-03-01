package com.telda.data.repository

import com.telda.data.remote.MoviesApis
import com.telda.domain.model.popular.MoviesGateway
import com.telda.domain.model.popular.MoviesResponse
import retrofit2.Response
import javax.inject.Inject

class MoviesRepository @Inject constructor(
    private val api: MoviesApis
) :
    MoviesGateway {
    override suspend fun requestPopularMovies(): Response<MoviesResponse> =
        api.requestPopularMovies()

}