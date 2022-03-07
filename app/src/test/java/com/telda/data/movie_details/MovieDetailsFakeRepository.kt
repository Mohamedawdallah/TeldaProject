package com.telda.data.movie_details

import com.telda.domain.model.movie_details.MovieDetailsGateway
import com.telda.domain.model.movie_details.credit.Cast
import com.telda.domain.model.movie_details.credit.MovieCreditsResponse
import com.telda.domain.model.movie_details.details.MovieDetailsResponse
import com.telda.domain.model.movies_popular.Movie
import com.telda.domain.model.movies_popular.MoviesResponse
import retrofit2.Response

class MovieDetailsFakeRepository : MovieDetailsGateway {
    override suspend fun requestMovieDetails(movieId: Int): Response<MovieDetailsResponse> {
        val movies = ArrayList<Movie>()
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())

        val movieDetailsResponse = MovieDetailsResponse()

        return if (movieId != 0) {
            Response.success(movieDetailsResponse)
        } else {
            Response.success(null)
        }
    }

    override suspend fun requestMovieSimilar(movieId: Int): Response<MoviesResponse> {
        val movies = ArrayList<Movie>()
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())
        movies.add(Movie())

        val movieSimilarResponse = MoviesResponse(results = movies)

        return if (movieId != 0) {
            Response.success(movieSimilarResponse)
        } else {
            Response.success(null)
        }
    }

    override suspend fun requestMovieCredit(movieId: Int): Response<MovieCreditsResponse> {
        val castMembers = ArrayList<Cast>()
        castMembers.add(Cast())
        castMembers.add(Cast())
        castMembers.add(Cast())
        castMembers.add(Cast())

        val movieCreditsResponse = MovieCreditsResponse(cast = castMembers)

        return if (movieId != 0) {
            Response.success(movieCreditsResponse)
        } else {
            Response.success(null)
        }

    }
}