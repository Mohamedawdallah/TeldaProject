package com.telda.data

import com.telda.domain.model.movies_popular.Movie
import com.telda.domain.model.movies_popular.MoviesGateway
import com.telda.domain.model.movies_popular.MoviesResponse
import retrofit2.Response

class MoviesPopularFakeRepository : MoviesGateway {

    override suspend fun requestPopularMovies(): Response<MoviesResponse> {
        val movies = ArrayList<Movie>()
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())

        val moviesPopularResponse = MoviesResponse(results = movies)

        return Response.success(moviesPopularResponse)

    }

    override suspend fun requestSearchMovies(searchText: String): Response<MoviesResponse> {
        val movies = ArrayList<Movie>()
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())

        val moviesPopularResponse = MoviesResponse(results = movies)

        return if (searchText.isNotEmpty()) {
            Response.success(moviesPopularResponse)
        } else {
            Response.success(null)
        }
    }
}