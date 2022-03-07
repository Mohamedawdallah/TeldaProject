package com.telda.domain.model.movie_details.details

import java.text.DecimalFormat
import java.text.NumberFormat

data class MovieDetailsResponse(
    val id: Int = 0,
    val original_title: String = "",
    val overview: String = "",
    val poster_path: String = "",
    val release_date: String = "",
    val status: String = "",
    val title: String = "",
    val vote_average: Double = 0.0,
    val revenue: Int = 0
) {
    fun finalRevenue(): String {
        val formatter: NumberFormat = DecimalFormat("#,###")
        return formatter.format(revenue)
    }
}