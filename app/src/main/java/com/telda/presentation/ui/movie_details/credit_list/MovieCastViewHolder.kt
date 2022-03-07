package com.telda.presentation.ui.movie_details.credit_list

import androidx.recyclerview.widget.RecyclerView
import com.telda.databinding.MovieCastItemBinding
import com.telda.domain.model.movie_details.credit.Cast
import com.telda.presentation.ui.movie_details.MovieDetailsViewModel

class MovieCastViewHolder(
    private val movieCastItemBinding: MovieCastItemBinding,
    private val movieDetailsViewModel: MovieDetailsViewModel
) : RecyclerView.ViewHolder(movieCastItemBinding.root) {

    fun bind(moveCast: Cast) {
        movieCastItemBinding.movieCastObject = moveCast
        movieCastItemBinding.movieCastListener = movieDetailsViewModel
    }
}
