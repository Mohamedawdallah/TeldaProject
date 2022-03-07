package com.telda.presentation.ui.movie_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.telda.databinding.DialogMovieDetailsBinding
import com.telda.presentation.ui.movie_details.credit_list.MovieCastAdapter
import com.telda.presentation.ui.movie_details.similar_list.MovieSimilarAdapter
import com.telda.presentation.utils.EventObserver
import com.telda.presentation.utils.manager.BaseBottomSheet
import com.telda.presentation.utils.recyclerAnimationExtension
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsDialog : BaseBottomSheet() {
    private lateinit var movieDetailsBinding: DialogMovieDetailsBinding
    private val movieDetailsArgs: MovieDetailsDialogArgs by navArgs()
    private val movieDetailsViewModel: MovieDetailsViewModel by viewModels()
    private lateinit var movieCastAdapter: MovieCastAdapter
    private lateinit var movieSimilarAdapter: MovieSimilarAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        movieDetailsBinding = DialogMovieDetailsBinding.inflate(inflater, container, false)
        movieDetailsBinding.movieDetailsListener = movieDetailsViewModel

        observeOnScreenData()
        requestScreenData()

        return movieDetailsBinding.root
    }

    private fun observeOnScreenData() {
        observeMovieDetailsData()
        observeMovieSimilarData()
        observeMovieCreditsData()
        observeClose()
    }

    private fun requestScreenData() {
        movieDetailsViewModel.handleMovieDetailsApis(movieDetailsArgs.movieObject.movieId)
          }

    private fun observeMovieCreditsData() {
        movieDetailsViewModel.observeMovieCastSuccess.observe(viewLifecycleOwner, EventObserver {
            movieCastAdapter =
                MovieCastAdapter(it.cast, movieDetailsViewModel)
            movieDetailsBinding.apply {
                rvMoveCast.apply {
                    setHasFixedSize(true)
                    layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    adapter = movieCastAdapter
                    recyclerAnimationExtension(this)
                }
            }
        })
    }

    private fun observeMovieSimilarData() {
        movieDetailsViewModel.observeMovieSimilarSuccess.observe(viewLifecycleOwner, EventObserver {
            movieSimilarAdapter =
                MovieSimilarAdapter(it.results, movieDetailsViewModel)
            movieDetailsBinding.apply {
                rvMovieSimilar.apply {
                    setHasFixedSize(true)
                    layoutManager =
                        LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                    adapter = movieSimilarAdapter
                    recyclerAnimationExtension(this)
                }
            }
        })
    }

    private fun observeMovieDetailsData() {
        movieDetailsViewModel.observeMovieDetailsSuccess.observe(viewLifecycleOwner, EventObserver {
            movieDetailsBinding.movieDetailsObject = it
        })
    }


    private fun observeClose() {
        movieDetailsViewModel.observeClose.observe(viewLifecycleOwner, EventObserver {
                dismiss()
        })
    }

}