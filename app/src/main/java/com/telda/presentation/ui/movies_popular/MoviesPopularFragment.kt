package com.telda.presentation.ui.movies_popular

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.telda.databinding.FragmentPopularMoviesBinding
import com.telda.presentation.ui.movies_popular.list.MoviesPopularAdapter
import com.telda.presentation.utils.EventObserver
import com.telda.presentation.utils.recyclerAnimationExtension
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesPopularFragment : Fragment() {
    private lateinit var moviesPopularBinding: FragmentPopularMoviesBinding
    private val moviesPopularViewModel: MoviesPopularViewModel by viewModels()
    private lateinit var moviesPopularAdapter: MoviesPopularAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        moviesPopularBinding = FragmentPopularMoviesBinding.inflate(inflater, container, false)
        moviesPopularBinding.movieListener = moviesPopularViewModel

        observeMoviesPopularData()
        observeMoviesSearchData()
        observeMovieClicked()

        moviesPopularBinding.searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                moviesPopularViewModel.moviesSearch(p0.toString())
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })



        return moviesPopularBinding.root
    }

    private fun observeMoviesPopularData() {
        moviesPopularViewModel.observeMoviePopularSuccess.observe(viewLifecycleOwner,
            EventObserver { moviesList ->

                moviesPopularAdapter =
                    MoviesPopularAdapter(moviesList.results, moviesPopularViewModel)
                moviesPopularBinding.apply {
                    rvPopularMoviesList.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = moviesPopularAdapter
                        recyclerAnimationExtension(this)
                    }
                }
            }
        )
    }

    private fun observeMoviesSearchData() {
        moviesPopularViewModel.observeMovieSearchSuccess.observe(viewLifecycleOwner,
            EventObserver { moviesList ->
                moviesPopularAdapter =
                    MoviesPopularAdapter(moviesList.results, moviesPopularViewModel)
                moviesPopularBinding.apply {
                    rvPopularMoviesList.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(requireContext())
                        adapter = moviesPopularAdapter
                        recyclerAnimationExtension(this)
                        moviesPopularAdapter.notifyDataSetChanged()
                    }
                }
            }
        )
    }

    private fun observeMovieClicked() {
        moviesPopularViewModel.observeMovieClicked.observe(
            viewLifecycleOwner,
            EventObserver { Movie ->
                val productDetails =
                    MoviesPopularFragmentDirections.actionMoviesPopularFragmentToMovieDetailsFragment(Movie)
                findNavController().navigate(productDetails)
            })
    }
}