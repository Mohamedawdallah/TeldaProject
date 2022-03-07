package com.telda.presentation.ui.movie_details.similar_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.telda.databinding.ItemMovieSimilarBinding
import com.telda.domain.model.movies_popular.Movie
import com.telda.presentation.ui.movie_details.MovieDetailsViewModel

class MovieSimilarAdapter(
    private val movieSimilarList: ArrayList<Movie>,
    private val movieDetailsViewModel: MovieDetailsViewModel
) : RecyclerView.Adapter<MovieSimilarViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSimilarViewHolder =
        MovieSimilarViewHolder(
            ItemMovieSimilarBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), movieDetailsViewModel
        )

    override fun onBindViewHolder(holder: MovieSimilarViewHolder, position: Int) {
        holder.bind(movieSimilarList[position])
    }

    override fun getItemCount(): Int {
        return movieSimilarList.size
    }
}