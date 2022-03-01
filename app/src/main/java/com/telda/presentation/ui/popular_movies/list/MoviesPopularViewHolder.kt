package com.telda.presentation.ui.popular_movies.list

import androidx.recyclerview.widget.RecyclerView
import com.telda.databinding.ItemMovieBinding
import com.telda.domain.model.popular.Movie
import com.telda.presentation.ui.popular_movies.MoviesPopularViewModel

class MoviesPopularViewHolder(
    private val itemMovieBinding: ItemMovieBinding,
    private val moviesPopularViewModel: MoviesPopularViewModel
) : RecyclerView.ViewHolder(itemMovieBinding.root) {

    fun bind(movie: Movie) {
        itemMovieBinding.movieObject = movie
        itemMovieBinding.movieListener = moviesPopularViewModel
    }
}
