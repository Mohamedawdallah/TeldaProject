package com.telda.presentation.ui.movie_details.similar_list

import androidx.recyclerview.widget.RecyclerView
import com.telda.databinding.ItemMovieSimilarBinding
import com.telda.domain.model.movies_popular.Movie
import com.telda.presentation.ui.movie_details.MovieDetailsViewModel

class MovieSimilarViewHolder(
    private val movieSimilarItemBinding: ItemMovieSimilarBinding,
    private val movieDetailsViewModel: MovieDetailsViewModel
) : RecyclerView.ViewHolder(movieSimilarItemBinding.root) {

    fun bind(moveSimilar: Movie) {
        movieSimilarItemBinding.movieSimilarObject = moveSimilar
        movieSimilarItemBinding.movieSimilarListener = movieDetailsViewModel
    }
}
