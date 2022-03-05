package com.telda.presentation.ui.profile

import com.telda.data.MoviesPopularFakeRepository
import com.telda.data.utils.Resource
import com.telda.domain.usecase.MoviesPopularUseCase
import com.telda.domain.usecase.MoviesSearchUseCase
import com.telda.presentation.ui.popular_movies.MoviesPopularViewModel
import com.telda.presentation.utils.manager.ResponseManager
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test


class MoviesPopularViewModelTest {

    private lateinit var moviesPopularUseCase: MoviesPopularUseCase
    private lateinit var moviesSearchUseCase: MoviesSearchUseCase
    private var profileFakeRepository = MoviesPopularFakeRepository()
    private lateinit var moviesPopularViewModel: MoviesPopularViewModel
    private lateinit var responseManager: ResponseManager


    @Before
    fun setup() {
        responseManager = ResponseManager()
        moviesPopularUseCase = MoviesPopularUseCase(profileFakeRepository)
        moviesSearchUseCase = MoviesSearchUseCase(profileFakeRepository)
        moviesPopularViewModel = MoviesPopularViewModel(responseManager,moviesPopularUseCase, moviesSearchUseCase)
    }

    @Test
    fun `getMoviesPopular() return success`() = runBlocking {

        //Act
        val result = moviesPopularUseCase.requestPopularMovies()

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getProducts() with empty token then return failed`() = runBlocking {
        //Arrange
        val token = ""

        //Act
        val result = moviesPopularUseCase.requestPopularMovies()

        //Assert
        assert(result is Resource.Failed)
    }

}