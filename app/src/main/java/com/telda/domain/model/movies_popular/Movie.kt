package com.telda.domain.model.movies_popular

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.gson.annotations.SerializedName
import com.telda.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
class Movie : BaseObservable(), Parcelable {
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
    @SerializedName("backdrop_path")
    var moviePoster: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.moviePoster)
        }

}

