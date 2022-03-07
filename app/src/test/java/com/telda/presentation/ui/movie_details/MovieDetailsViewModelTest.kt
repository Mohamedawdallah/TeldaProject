package com.telda.presentation.ui.movie_details

import com.telda.data.movie_details.MovieDetailsFakeRepository
import com.telda.data.utils.Resource
import com.telda.domain.usecase.details.MovieCreditsUseCase
import com.telda.domain.usecase.details.MovieDetailsUseCase
import com.telda.domain.usecase.details.MovieSimilarUseCase
import com.telda.presentation.utils.manager.ResponseManager
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MovieDetailsViewModelTest {
    private lateinit var movieDetailsUseCase: MovieDetailsUseCase
    private lateinit var movieSimilarUseCase: MovieSimilarUseCase
    private lateinit var movieCreditsUseCase: MovieCreditsUseCase

    private var movieDetailsFakeRepository = MovieDetailsFakeRepository()
    private lateinit var movieDetailsViewModel: MovieDetailsViewModel
    private lateinit var responseManager: ResponseManager

    @Before
    fun setup() {
        responseManager = Mockito.mock(ResponseManager::class.java)
        movieDetailsUseCase = MovieDetailsUseCase(movieDetailsFakeRepository)
        movieSimilarUseCase = MovieSimilarUseCase(movieDetailsFakeRepository)
        movieCreditsUseCase = MovieCreditsUseCase(movieDetailsFakeRepository)

        movieDetailsViewModel =
            Mockito.spy(
                MovieDetailsViewModel(
                    responseManager,
                    movieDetailsUseCase,
                    movieSimilarUseCase,
                    movieCreditsUseCase

                )
            )
    }


    @Test
    fun `getMovieDetails() with correct movieId then return success`() = runBlocking {
        //Arrange
        val movieId = 12345

        //Act
        val result = movieDetailsUseCase.requestMovieDetails(movieId)

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getMovieDetails() with wrong movieId  then return Failed`() = runBlocking {
        //Arrange
        val movieId = 0

        //Act
        val result = movieDetailsUseCase.requestMovieDetails(movieId)

        //Assert
        assert(result is Resource.Failed)
    }

    @Test
    fun `getMovieSimilar() with correct movieId then return success`() = runBlocking {
        //Arrange
        val movieId = 12345

        //Act
        val result = movieSimilarUseCase.requestMovieSimilar(movieId)

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getMovieSimilar() with wrong movieId  then return Failed`() = runBlocking {
        //Arrange
        val movieId = 0

        //Act
        val result = movieSimilarUseCase.requestMovieSimilar(movieId)

        //Assert
        assert(result is Resource.Failed)
    }

    @Test
    fun `getMovieCredits() with correct movieId then return success`() = runBlocking {
        //Arrange
        val movieId = 12345

        //Act
        val result = movieCreditsUseCase.requestMovieCredits(movieId)

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getMovieCredits() with wrong movieId  then return Failed`() = runBlocking {
        //Arrange
        val movieId = 0

        //Act
        val result = movieCreditsUseCase.requestMovieCredits(movieId)

        //Assert
        assert(result is Resource.Failed)
    }
}