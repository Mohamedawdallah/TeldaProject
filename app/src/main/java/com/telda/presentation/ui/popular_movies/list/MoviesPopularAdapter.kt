package com.telda.presentation.ui.popular_movies.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.telda.databinding.ItemMovieBinding
import com.telda.domain.model.popular.Movie
import com.telda.presentation.ui.popular_movies.MoviesPopularViewModel

class MoviesPopularAdapter(
    private val moviesList: ArrayList<Movie>,
    private val moviePopularViewModel: MoviesPopularViewModel
) : RecyclerView.Adapter<MoviesPopularViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesPopularViewHolder =
        MoviesPopularViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), moviePopularViewModel
        )

    override fun onBindViewHolder(holder: MoviesPopularViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }
}