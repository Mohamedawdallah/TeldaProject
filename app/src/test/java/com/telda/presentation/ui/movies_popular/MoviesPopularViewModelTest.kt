package com.telda.presentation.ui.movies_popular

import com.telda.data.movies_popular.MoviesPopularFakeRepository
import com.telda.data.utils.Resource
import com.telda.domain.usecase.movies.MoviesPopularUseCase
import com.telda.domain.usecase.movies.MoviesSearchUseCase
import com.telda.presentation.utils.manager.ResponseManager
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MoviesPopularViewModelTest {

    private lateinit var moviesPopularUseCase: MoviesPopularUseCase
    private lateinit var moviesSearchUseCase: MoviesSearchUseCase
    private var moviePopularFakeRepository = MoviesPopularFakeRepository()
    private lateinit var moviesPopularViewModel: MoviesPopularViewModel
    private lateinit var responseManager: ResponseManager


    @Before
    fun setup() {
        responseManager = Mockito.mock(ResponseManager::class.java)
        moviesPopularUseCase = MoviesPopularUseCase(moviePopularFakeRepository)
        moviesSearchUseCase = MoviesSearchUseCase(moviePopularFakeRepository)
        moviesPopularViewModel =
            Mockito.spy(
                MoviesPopularViewModel(
                    responseManager,
                    moviesPopularUseCase,
                    moviesSearchUseCase
                )
            )
    }

    @Test
    fun `getMoviesPopular() return success`() = runBlocking {

        //Act
        val result = moviesPopularUseCase.requestPopularMovies()

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getMoviesSearch() with correct search text request then return success`() = runBlocking {
        //Arrange
        val searchText = "spider"

        //Act
        val result = moviesSearchUseCase.requestSearchMovies(searchText)

        //Assert
        assert(result is Resource.Success)
    }

    @Test
    fun `getMoviesSearch() with wrong search text request then return Failed`() = runBlocking {
        //Arrange
        val searchText = ""

        //Act
        val result = moviesSearchUseCase.requestSearchMovies(searchText)

        //Assert
        assert(result is Resource.Failed)
    }


}