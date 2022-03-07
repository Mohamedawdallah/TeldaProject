package com.telda.presentation.ui.movie_details.credit_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.telda.databinding.MovieCastItemBinding
import com.telda.domain.model.movie_details.credit.Cast
import com.telda.presentation.ui.movie_details.MovieDetailsViewModel

class MovieCastAdapter(
    private val movieCastList: ArrayList<Cast>,
    private val movieDetailsViewModel: MovieDetailsViewModel
) : RecyclerView.Adapter<MovieCastViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCastViewHolder =
        MovieCastViewHolder(
            MovieCastItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), movieDetailsViewModel
        )

    override fun onBindViewHolder(holder: MovieCastViewHolder, position: Int) {
        holder.bind(movieCastList[position])
    }

    override fun getItemCount(): Int {
        return movieCastList.size
    }
}