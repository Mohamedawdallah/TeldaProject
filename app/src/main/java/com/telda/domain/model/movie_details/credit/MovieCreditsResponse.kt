package com.telda.domain.model.movie_details.credit

data class MovieCreditsResponse(
    var cast: ArrayList<Cast> = ArrayList(),
    val id: Int = 0
)