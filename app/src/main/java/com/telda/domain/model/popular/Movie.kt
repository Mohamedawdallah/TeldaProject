package com.telda.domain.model.popular

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.telda.BR


class Movie : BaseObservable() {
    @SerializedName("id")
    var movieId: Int = 0

    @get:Bindable
    @SerializedName("original_title")
    var movieTitle: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.movieTitle)
        }

    @get:Bindable
    @SerializedName("overview")
    var movieOverviewTitle: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.movieOverviewTitle)
        }

    @get:Bindable
    @SerializedName("popularity")
    var moviePopularity: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.moviePopularity)
        }

    @get:Bindable
    @SerializedName("release_date")
    var movieReleaseDate: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.movieReleaseDate)
        }

    @get:Bindable
    @SerializedName("backdrop_path")
    var moviePoster: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.moviePoster)
        }

}

